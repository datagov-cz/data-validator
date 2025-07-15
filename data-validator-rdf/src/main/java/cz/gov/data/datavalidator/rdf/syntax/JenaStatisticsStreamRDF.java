package cz.gov.data.datavalidator.rdf.syntax;

import org.apache.jena.graph.Triple;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.sparql.core.Quad;

public class JenaStatisticsStreamRDF implements StreamRDF {

    private long counter = 0;

    @Override
    public void start() {
        // No action.
    }

    @Override
    public void triple(Triple triple) {
        ++this.counter;
    }

    @Override
    public void quad(Quad quad) {
        ++this.counter;
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

    public boolean isEmpty() {
        return counter == 0;
    }

}
