package cz.mvcr.datavalidator.rdf.syntax;

import cz.mvcr.datavalidator.core.DataValidator;
import cz.mvcr.datavalidator.core.Report;
import cz.mvcr.datavalidator.core.ReportFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;

public class RdfSyntaxRdf4jValidator implements DataValidator {

    private static final ReportFactory reportFactory =
            ReportFactory.getInstance(RdfSyntaxRdf4jValidator.class);

    @Override
    public List<Report> validate(File file) {
        List<Report> result = new ArrayList<>();
        try (InputStream stream = new FileInputStream(file)) {
            RDFFormat format = getFormat(file);
            RDFParser rdfParser = Rio.createParser(format);
            // Do nothing handler.
            rdfParser.setRDFHandler(new AbstractRDFHandler() {} );
            rdfParser.parse(stream, "http://localhost/");
        } catch (IOException | RuntimeException ex) {
            result.add(reportFactory.error(ex.getMessage()));
        }
        return result;
    }

    private static RDFFormat getFormat(File file) throws IOException {
        var format = Rio.getParserFormatForFileName(file.getName());
        if (format.isEmpty()) {
            throw new IOException(
                    "Can't determine file format : " + file.getName());
        }
        return format.get();
    }

}
