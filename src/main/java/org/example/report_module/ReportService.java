package org.example.report_module;

import org.springframework.stereotype.Service;

@Service
class ReportService {

    public void createReport(String reportType) {
        ReportHandler weeklyHandler = new WeeklyReportHandler();
        ReportHandler monthlyHandler = new MonthlyReportHandler();
        ReportHandler annualHandler = new AnnualReportHandler();

        // Setting up the chain of responsibility
        weeklyHandler.setNextHandler(monthlyHandler);
        monthlyHandler.setNextHandler(annualHandler);

        // Process the request
        weeklyHandler.handleRequest(reportType);
    }

}
