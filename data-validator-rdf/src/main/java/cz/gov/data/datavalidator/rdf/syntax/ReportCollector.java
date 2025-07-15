package cz.gov.data.datavalidator.rdf.syntax;

import cz.gov.data.datavalidator.core.Report;
import cz.gov.data.datavalidator.core.ReportFactory;
import cz.gov.data.datavalidator.core.SuppressFBWarnings;
import org.apache.jena.riot.RiotException;
import org.apache.jena.riot.system.ErrorHandler;

import java.util.List;

@SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "Objective is to fill in the given list.")
public class ReportCollector implements ErrorHandler {

    private final ReportFactory reportFactory;

    private final List<Report> reports;

    public ReportCollector(ReportFactory reportFactory, List<Report> reports) {
        this.reportFactory = reportFactory;
        this.reports = reports;
    }

    @Override
    public void warning(String message, long line, long col) {
        reports.add(reportFactory.warn(message, (int) line, (int) col));
    }

    @Override
    public void error(String message, long line, long col) {
        reports.add(reportFactory.error(message, (int) line, (int) col));
    }

    @Override
    public void fatal(String message, long line, long col) {
        reports.add(reportFactory.error(message, (int) line, (int) col));
        throw new RiotException();
    }

}
