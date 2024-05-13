# Data Validator

## Running using Docker
Data Validator is available as Docker image at GitHub registry.

## Running using GitHub action
The configuration bellow runs the validator with every push and pull request.
Create an action file (e.g. `.github/workflows/data-validator.yml`) with following content:
```yaml
name: Validate data files
on:
  push:
  pull_request:
jobs:
  validate:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout
      uses: actions/checkout@v4
    - name: Data validator
      uses: datagov-cz/data-validator/github@v2
      with:
        configuration: file://./.github/workflows/validate-syntax.ttl
```
Part of the configuration is path to configuration file (`.github/workflows/validate-syntax.ttl`).
Please see section [Configuring the validation] for more information about this file.

## Configuring the validation
Data Validator utilize RDF-based configuration to configure the validation process.
See `documentation/example-configurations.md` file for examples of Data Validator configurations.

## Validators

### urn:DataValidator:TitaniumJsonLdSyntax
Check that file can be loaded as JSON-LD file with [Titanium JSON-LD](https://github.com/filip26/titanium-json-ld).

### urn:DataValidator:JenaRdfNotEmpty
Using [Jena](https://jena.apache.org/) loads the file and check it is not empty.

### urn:DataValidator:JacksonJsonSyntax
Check that file can be loaded as JSON using [Jackson](https://github.com/FasterXML/jackson).

### urn:DataValidator:JenaRdfSyntax
Check that file can be loaded as RDF file using [Jena](https://jena.apache.org/).

#### Known issues and limitations
- Validator fails to detect space between literal and language tag.

### urn:DataValidator:Rdf4jRdfSyntax
Check that file can be loaded as RDF file using [Eclipse RDF4J](https://rdf4j.org/).

### urn:DataValidator:Dom4jXmlSyntax
Check that file can be loaded as XML file using [Dom4j](https://dom4j.github.io/).

### urn:DataValidator:EveritJsonSchema
Validate JSON file using [JSON Schema Validator](https://github.com/everit-org/json-schema).

#### Configuration
- urn:schema : Path to JSON-Schema file.

### urn:DataValidator:XercesXmlSchema
Validate XML document using [dom4j](https://dom4j.github.io/) and [Apache Xerces2](https://mvnrepository.com/artifact/org.opengis.cite.xerces/xercesImpl-xsd11).

#### Configuration
- urn:schemaUrl : Path to schema file.

#### Known issues and limitations
- Apache Xerces2 does not fully support XML Schema 1.1.

### urn:DataValidator:JenaRdfShaclSchema
Using [Jena](https://jena.apache.org/) loads RDF content and check compliance with given [SHACL](https://www.w3.org/TR/shacl/) shape.

#### Configuration
- urn:shaclUrl : Path to file with SHACL.

Tento repozitář je udržován v rámci projektu OPZ č. CZ.03.4.74/0.0/0.0/15_025/0004172.
![Evropská unie - Evropský sociální fond - Operační program Zaměstnanost](https://data.gov.cz/images/ozp_logo_cz.jpg)
