package cz.mvcr.datavalidator.core;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class RdfAdapter {

    @FunctionalInterface
    public interface UrlToStream {

        InputStream open(URL url) throws IOException;

    }

    public static List<Statement> asStatements(File file) throws IOException {
        RDFFormat format = getFormat(file);
        List<Statement> statements = new ArrayList<>();
        RDFParser rdfParser = Rio.createParser(format);
        rdfParser.setRDFHandler(new AbstractRDFHandler() {
            @Override
            public void handleStatement(Statement st) {
                statements.add(st);
            }
        });
        try (InputStream input = new FileInputStream(file)) {
            rdfParser.parse(input, "http://localhost/");
        }
        return statements;
    }

    private static RDFFormat getFormat(File file) throws IOException {
        var format = Rio.getParserFormatForFileName(file.getName());
        if (format.isEmpty()) {
            throw new IOException(
                    "Can't determine file format : " + file.getName());
        }
        return format.get();
    }

    public static List<Statement> asStatements(URL url) throws IOException {
        return asStatements(url, URL::openStream);
    }

    public static List<Statement> asStatements(
            URL url, UrlToStream urlToStream) throws IOException {
        switch (url.getProtocol()) {
            case "file":
                try {
                    return asStatements(new File(url.toURI()));
                } catch (URISyntaxException ex) {
                    throw new IOException("Invalid URL.", ex);
                }
            case "http":
            case "https":
                return fromHttp(url, urlToStream);
            default:
                throw new IOException(
                        "Unsupported protocol: " + url.getProtocol());
        }
    }


    private static List<Statement> fromHttp(
            URL url, UrlToStream urlToStream) throws IOException {
        List<Statement> result = new ArrayList<>();
        try (InputStream stream = urlToStream.open(url)) {
            // TODO: This should use content-negotiation.
            RDFParser parser = Rio.createParser(RDFFormat.TURTLE);
            parser.setRDFHandler(new StatementCollector(result));
            parser.parse(stream, url.toString());
        }
        return result;
    }

    public static void toFile(List<Statement> statements, File file)
            throws IOException {
        RDFFormat format =
                Rio.getParserFormatForFileName(file.getName())
                        .orElse(RDFFormat.N3);
        file.getParentFile().mkdirs();
        try (OutputStream stream = new FileOutputStream(file)) {
            Rio.write(statements, stream, format);
        }
    }

}

