package org.example.report_module;

import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.report_module.dto.ReportDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AnnualReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType, BudgetDto budgetDto, ReportDto report) {
        if ("annual".equalsIgnoreCase(reportType)) {
            LocalDate now = LocalDate.now();
            LocalDate yearAgo = now.minusYears(1);

            List<ExpenseDto> annualExpenses = budgetDto.getExpenses().stream()
                    .filter(expense -> expense.getDate().isAfter(yearAgo))
                    .toList();

            report.setExpenses(annualExpenses);
            report.setTotalAmount(annualExpenses.stream()
                    .map(ExpenseDto::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType, budgetDto, report);
        }
    }
}
