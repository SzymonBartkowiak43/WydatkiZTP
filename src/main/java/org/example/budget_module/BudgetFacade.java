package org.example.budget_module;

import lombok.AllArgsConstructor;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.CategoryDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.budget_module.dto.RevenueDto;
import org.example.report_module.ReportFacade;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Component
public class BudgetFacade {

    private final BudgetService budgetService;
    private final ReportFacade reportFacade = ReportFacade.getInstance();

    public BudgetDto createBudget(String name, BigDecimal amount) {
        Budget budget = budgetService.createBudget(name, amount);

        List<CategoryDto> categoryDtos = budget.getCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .toList();

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount(),categoryDtos);
    }

    public Long addRevenue(Long budgetId, RevenueDto revenueDto) {
        Long l = budgetService.addRevenueToBudget(budgetId, revenueDto);
        return budgetId;
    }

    public BudgetDto addCategoryToBudget(Long id, String categoryName) {
        Budget budget = budgetService.addCategory(id, categoryName);

        List<CategoryDto> categoryDtos = budget.getCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .toList();

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount(),categoryDtos);
    }

    public BudgetDto getBudget(Long id) {
        Budget budget = budgetService.getBudget(id);

        List<CategoryDto> categoryDtos = budget.getCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .toList();

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount(),categoryDtos);
    }

    public BudgetDto addExpense(Long budgetId, ExpenseDto expenseDto) {
        Budget budget = budgetService.addExpense(budgetId, expenseDto);

        List<CategoryDto> categoryDtos = budget.getCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .toList();

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount(),categoryDtos);
    }

    public String generateRaport() {
        reportFacade.generate("weekly");
        return "success";
    }

}
