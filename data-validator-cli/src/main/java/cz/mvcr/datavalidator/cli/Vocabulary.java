package cz.mvcr.datavalidator.cli;

public class Vocabulary {

    private static final String prefix = "urn:";

    public static final String Configuration =
            prefix + "DataValidatorConfiguration";

    public static final String hasRule =
            prefix + "rule";

    public static final String hasPattern =
            prefix + "pattern";

    public static final String hasValidator =
            prefix + "validator";

    public static final String hasPath =
            prefix + "path";

    public static final String hasRecursive =
            prefix + "recursive";

    public static final String JacksonJsonSyntax =
            prefix + "JacksonJsonSyntax";

    public static final String JacksonXmlSyntax =
            prefix + "JacksonXmlSyntax";

    public static final String JenaRdfSyntax =
            prefix + "JenaRdfSyntax";

}