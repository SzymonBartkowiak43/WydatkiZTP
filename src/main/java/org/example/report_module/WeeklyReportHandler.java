package org.example.report_module;


class WeeklyReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType) {
        if ("weekly".equalsIgnoreCase(reportType)) {
            System.out.println("Generuję raport tygodniowy");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType);
        } else {
            System.out.println("Nieobsługiwany typ raportu: " + reportType);
        }
    }
}