package org.example.report_module;

import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.report_module.dto.ReportDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MonthlyReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType, BudgetDto budgetDto, ReportDto report) {
        if ("monthly".equalsIgnoreCase(reportType)) {
            LocalDate now = LocalDate.now();
            LocalDate monthAgo = now.minusMonths(1);

            List<ExpenseDto> monthlyExpenses = budgetDto.getExpenses().stream()
                    .filter(expense ->
                            !expense.getDate().isBefore(monthAgo) &&
                                    !expense.getDate().isAfter(now))
                    .toList();
            report.setExpenses(monthlyExpenses);
            BigDecimal totalAmount = monthlyExpenses.stream()
                    .map(ExpenseDto::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            report.setTotalAmount(totalAmount);

        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType, budgetDto, report);
        }
    }
}

