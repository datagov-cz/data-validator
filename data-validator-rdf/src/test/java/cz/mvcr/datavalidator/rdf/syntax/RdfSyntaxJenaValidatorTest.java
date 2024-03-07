package cz.mvcr.datavalidator.rdf.syntax;

import cz.mvcr.datavalidator.core.Report;
import cz.mvcr.datavalidator.rdf.TestUtils;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RdfSyntaxJenaValidatorTest {

    @Test
    public void invalidFile003() {
        RdfSyntaxJenaValidator validator = new RdfSyntaxJenaValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/invalid-003.ttl"));
        Assertions.assertEquals(1, actual.size());
    }

    /**
     * This test actually fail as Jena is not capable to reporting the error.
     */
    @Test
    public void issue008Failing() {
        RdfSyntaxJenaValidator validator = new RdfSyntaxJenaValidator();
        List<Report> actual = validator.validate(
                TestUtils.fileFromResource("syntax/issue-008.ttl"));
        Assertions.assertEquals(0, actual.size());
    }

}
