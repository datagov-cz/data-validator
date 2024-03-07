package cz.mvcr.datavalidator.rdf.syntax;

import org.apache.jena.graph.Triple;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.sparql.core.Quad;

public class NoWhereStreamRDF implements StreamRDF {

    @Override
    public void start() {
        // No action.
    }

    @Override
    public void triple(Triple triple) {
        // No action.
    }

    @Override
    public void quad(Quad quad) {
        // No action.
    }

    @Override
    public void base(String base) {
        // No action.
    }

    @Override
    public void prefix(String prefix, String iri) {
        // No action.
    }

    @Override
    public void finish() {
        // No action.
    }

}
