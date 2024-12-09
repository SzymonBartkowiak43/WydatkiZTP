package org.example.report_module;

class MonthlyReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType) {
        if ("monthly".equalsIgnoreCase(reportType)) {
            System.out.println("Generuję raport miesięczny");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType);
        } else {
            System.out.println("Nieobsługiwany typ raportu: " + reportType);
        }
    }
}