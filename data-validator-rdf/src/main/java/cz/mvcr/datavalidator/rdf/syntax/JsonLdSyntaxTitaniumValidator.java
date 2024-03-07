package cz.mvcr.datavalidator.rdf.syntax;

import com.apicatalog.jsonld.JsonLdError;
import com.apicatalog.jsonld.JsonLdErrorCode;
import com.apicatalog.jsonld.JsonLdOptions;
import com.apicatalog.jsonld.document.Document;
import com.apicatalog.jsonld.loader.DocumentLoaderOptions;
import cz.mvcr.datavalidator.core.DataValidator;
import cz.mvcr.datavalidator.core.Report;
import cz.mvcr.datavalidator.core.ReportFactory;
import jakarta.json.stream.JsonLocation;
import jakarta.json.stream.JsonParsingException;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class JsonLdSyntaxTitaniumValidator implements DataValidator {

    private static final ReportFactory reportFactory =
            ReportFactory.getInstance(JsonLdSyntaxTitaniumValidator.class);

    @Override
    public List<Report> validate(File file) {
        JsonLdOptions options = new JsonLdOptions();
        DocumentLoaderOptions loaderOptions = new DocumentLoaderOptions();
        try {
            loaderOptions.setExtractAllScripts(options.isExtractAllScripts());
            Document remoteDocument =
                    options.getDocumentLoader().loadDocument(
                            file.toURI(), loaderOptions);
            if (remoteDocument == null) {
                throw new JsonLdError(JsonLdErrorCode.LOADING_DOCUMENT_FAILED);
            }
        } catch (JsonLdError ex) {
            return onException(ex);
        }
        return Collections.emptyList();
    }

    private List<Report> onException(JsonLdError ex) {
        Throwable cause = ex.getCause();
        if (cause == null) {
            return Collections.singletonList(
                    reportFactory.error(ex.getMessage()));
        }
        if (cause instanceof JsonParsingException parsingException) {
            JsonLocation location = parsingException.getLocation();
            return Collections.singletonList(
                    reportFactory.error(
                            ex.getMessage(),
                            (int) location.getLineNumber(),
                            (int) location.getColumnNumber()));
        }
        return Collections.singletonList(
                reportFactory.error(ex.getMessage()));
    }

}
