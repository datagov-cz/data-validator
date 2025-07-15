package cz.gov.data.datavalidator.rdf.syntax;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;

public class Rdf4jStatisticsRDFHandler extends AbstractRDFHandler {

    private long counter = 0;

    @Override
    public void handleStatement(Statement st) throws RDFHandlerException {
        super.handleStatement(st);
        ++this.counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

}
