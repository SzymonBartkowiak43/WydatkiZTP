package org.example.report_module;


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

    public void generate(String reportType) {
        reportService.createReport(reportType);
    }
}