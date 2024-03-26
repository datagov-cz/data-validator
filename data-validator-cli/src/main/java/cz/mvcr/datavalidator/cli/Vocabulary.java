package cz.mvcr.datavalidator.cli;

public class Vocabulary {

    private static final String prefix = "urn:DataValidator:";

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

    public static final String Dom4jXmlSyntax =
            prefix + "Dom4jXmlSyntax";

    public static final String JenaRdfSyntax =
            prefix + "JenaRdfSyntax";

    public static final String Rdf4jRdfSyntax =
            prefix + "Rdf4jRdfSyntax";

    public static final String EveritJsonSchema =
            prefix + "EveritJsonSchema";

    public static final String XercesXmlSchema =
            prefix + "XercesXmlSchema";

    public static final String JenaRdfShaclSchema =
            prefix + "JenaRdfShaclSchema";

    public static final String TitaniumJsonLdSyntax =
            prefix + "TitaniumJsonLdSyntax";

    public static final String JenaRdfNotEmpty =
            prefix + "JenaRdfNotEmpty";

}
