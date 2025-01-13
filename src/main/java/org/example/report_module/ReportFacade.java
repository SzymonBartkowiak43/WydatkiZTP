package org.example.report_module;


import org.example.budget_module.dto.BudgetDto;
import org.example.report_module.dto.ReportDto;
import org.springframework.stereotype.Component;


@Component
public class ReportFacade {
    private static ReportFacade instance;
    private final ReportService reportService;

    private ReportFacade(ReportService reportService) {
        this.reportService = reportService;
    }

    public static synchronized ReportFacade getInstance() {
        if (instance == null) {
            ReportService reportService = new ReportService();
            instance = new ReportFacade(reportService);
        }
        return instance;
    }

    public ReportDto generate(String reportType, BudgetDto budget) {
        ReportDto report = ReportDto.builder().build();
        reportService.createReport(reportType, budget);
        return report;
    }
}