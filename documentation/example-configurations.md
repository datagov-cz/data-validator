# Example configurations

## Validate syntext
Validate syntax of files with extensions: *.jsonld, *.json, *.xml, *.ttl, *.trig, *.nq, *.nt, *.rdf.

```
@prefix dash: <http://datashapes.org/dash#> .
@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
@prefix schema: <http://schema.org/> .
@prefix sh: <http://www.w3.org/ns/shacl#> .
@prefix xsd: <http://www.w3.org/2001/XMLSchema#> .

<http://localhost/configuration> a <urn:DataValidatorConfiguration> ;
    <urn:rule> [
		<urn:pattern> ".*.jsonld" ;
		<urn:validator>
		    [ a <urn:TitaniumJsonLdSyntax> ; ]
    ], [
		<urn:pattern> ".*.json", ".*.jsonld" ;
		<urn:validator>
			[ a <urn:JacksonJsonSyntax> ; ]
	], [
		<urn:pattern> ".*.ttl", ".*.trig", ".*.nq", ".*.nt", ".*.rdf" ;
		<urn:validator>
			[ a <urn:JenaRdfSyntax> ; ]
			, [ a <urn:Rdf4jRdfSyntax> ; ]
	], [
		<urn:pattern> ".*.xml" ;
		<urn:validator>
			[ a <urn:Dom4jXmlSyntax> ; ]
	] ;
	<urn:recursive> true ;
    <urn:path> "./" ;
.
```
