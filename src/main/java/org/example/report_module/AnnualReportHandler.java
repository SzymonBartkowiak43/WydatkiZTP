package org.example.report_module;

class AnnualReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType) {
        if ("annual".equalsIgnoreCase(reportType)) {
            System.out.println("Generuję raport roczny");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType);
        } else {
            System.out.println("Nieobsługiwany typ raportu: " + reportType);
        }
    }
}