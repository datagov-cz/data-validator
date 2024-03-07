# Data Validator

## Running using Docker
Data Validator is available as Docker image at GitHub registry.

## Running using GitHub action
The configuration bellow runs the validator with every push and pull request.
Create an action file (e.g. `.github/workflows/data-validator.yml`) with following content:
```yaml
name: Validator2
on:
  push:
  pull_request:
jobs:
  validate:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout
      uses: actions/checkout@v2
    - name: Data validator
      uses: datagov-cz/data-validator/github@main
      with:
        configuration: file://./.github/workflows/validate-syntax.ttl
```
Part of the configuration is path to configuration file (`.github/workflows/validate-syntax.ttl`).
Please see section [Configuring the validation] for more information about this file.

## Configuring the validation
Data Validator utilize RDF-based configuration to configure the validation process.
See `documentation/example-configurations.md` file for examples of Data Validator configurations.

## Validators

### urn:TitaniumJsonLdSyntax
Check that file can be loaded as JSON-LD file with [Titanium JSON-LD](https://github.com/filip26/titanium-json-ld).

### urn:JenaRdfNotEmpty
Using [Jena](https://jena.apache.org/) load the file and check it is not empty.

### urn:JacksonJsonSyntax
Check that file can be loaded as JSON using [Jackson](https://github.com/FasterXML/jackson).

### urn:JenaRdfSyntax
Check that file can be loaded as RDF file using [Jena](https://jena.apache.org/).

### urn:Dom4jXmlSyntax
Check that file can be loaded as XML file using [Dom4j](https://dom4j.github.io/).

Tento repozitář je udržován v rámci projektu OPZ č. CZ.03.4.74/0.0/0.0/15_025/0004172.
![Evropská unie - Evropský sociální fond - Operační program Zaměstnanost](https://data.gov.cz/images/ozp_logo_cz.jpg)
