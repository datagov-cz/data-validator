package cz.mvcr.datavalidator.json.syntax;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import cz.mvcr.datavalidator.core.Report;
import cz.mvcr.datavalidator.core.DataValidator;
import cz.mvcr.datavalidator.core.ReportFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JsonSyntaxJacksonValidator implements DataValidator {

    private static final ReportFactory reportFactory =
            ReportFactory.getInstance(JsonSyntaxJacksonValidator.class);

    @Override
    public List<Report> validate(File file) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
        Object value;
        try {
            value = mapper.readTree(file);
        } catch (JsonParseException ex) {
            JsonLocation location = ex.getLocation();
            String message = ex.getMessage();
            return Collections.singletonList(reportFactory.error(
                    message, location.getLineNr(), location.getColumnNr()));
        } catch (IOException ex) {
            return Collections.singletonList(
                    reportFactory.error(ex.getMessage()));
        }
        if (value == null || value instanceof MissingNode) {
            return Collections.singletonList(
                    reportFactory.error("File is empty!"));
        }
        return Collections.emptyList();
    }

}
