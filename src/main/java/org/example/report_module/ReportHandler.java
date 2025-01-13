package org.example.report_module;

import org.example.budget_module.dto.BudgetDto;
import org.example.report_module.dto.ReportDto;

public abstract class ReportHandler {
    protected ReportHandler nextHandler;

    public void setNextHandler(ReportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String reportType, BudgetDto budgetDto, ReportDto report);
}
