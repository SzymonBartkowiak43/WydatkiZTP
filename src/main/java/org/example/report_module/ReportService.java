package org.example.report_module;

import org.example.budget_module.dto.BudgetDto;
import org.example.report_module.dto.ReportDto;
import org.springframework.stereotype.Service;

@Service
class ReportService {

    public void createReport(String reportType, BudgetDto budgetDto) {
        ReportHandler weeklyHandler = new WeeklyReportHandler();
        ReportHandler monthlyHandler = new MonthlyReportHandler();
        ReportHandler annualHandler = new AnnualReportHandler();

        weeklyHandler.setNextHandler(monthlyHandler);
        monthlyHandler.setNextHandler(annualHandler);

        ReportDto report = ReportDto.builder().build();
        weeklyHandler.handleRequest(reportType, budgetDto, report);
    }


}
