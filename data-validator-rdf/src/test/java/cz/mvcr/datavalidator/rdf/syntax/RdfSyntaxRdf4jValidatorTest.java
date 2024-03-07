package cz.mvcr.datavalidator.rdf.syntax;

import cz.mvcr.datavalidator.core.Report;
import cz.mvcr.datavalidator.rdf.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RdfSyntaxRdf4jValidatorTest {

    @Test
    public void invalidFile003() {
        RdfSyntaxRdf4jValidator validator = new RdfSyntaxRdf4jValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/invalid-003.ttl"));
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    public void issue008() {
        RdfSyntaxRdf4jValidator validator = new RdfSyntaxRdf4jValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/issue-008.ttl"));
        Assertions.assertEquals(1, actual.size());
    }

}
