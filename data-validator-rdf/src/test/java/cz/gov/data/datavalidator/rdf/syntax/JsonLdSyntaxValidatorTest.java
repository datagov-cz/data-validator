package cz.gov.data.datavalidator.rdf.syntax;

import cz.gov.data.datavalidator.core.Report;
import cz.gov.data.datavalidator.rdf.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class JsonLdSyntaxValidatorTest {

    @Test
    public void invalidFile000() {
        RdfSyntaxJenaValidator validator = new RdfSyntaxJenaValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/invalid-000.jsonld"));
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    public void invalidFile001() {
        RdfSyntaxJenaValidator validator = new RdfSyntaxJenaValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/invalid-001.jsonld"));
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    public void invalidFile002() {
        JsonLdSyntaxTitaniumValidator validator =
                new JsonLdSyntaxTitaniumValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/invalid-002.jsonld"));
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    public void validJsonLdV11File004() {
        JsonLdSyntaxTitaniumValidator validator =
                new JsonLdSyntaxTitaniumValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource(
                        "syntax/valid-jsonld-v11-004.jsonld"));
        Assertions.assertEquals(0, actual.size());
    }

}
