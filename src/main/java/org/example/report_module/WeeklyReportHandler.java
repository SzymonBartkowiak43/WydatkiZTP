package org.example.report_module;


import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.report_module.dto.ReportDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class WeeklyReportHandler extends ReportHandler {
    @Override
    public void handleRequest(String reportType, BudgetDto budgetDto, ReportDto report) {
        if ("weekly".equalsIgnoreCase(reportType)) {
            LocalDate now = LocalDate.now();
            LocalDate weekAgo = now.minusWeeks(1);

            List<ExpenseDto> weeklyExpenses = budgetDto.getExpenses().stream()
                    .filter(expense -> expense.getDate().isAfter(weekAgo.minusDays(1)) && expense.getDate().isBefore(now.plusDays(1)))
                    .toList();


            report.setExpenses(weeklyExpenses);
            report.setTotalAmount(weeklyExpenses.stream()
                    .map(ExpenseDto::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reportType, budgetDto, report);
        }
    }
}

