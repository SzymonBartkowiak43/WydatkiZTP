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

        return getBudgetDto(budget);
    }

    public BudgetDto addRevenue(Long budgetId, RevenueDto revenueDto) {
        Budget budget = budgetService.addRevenueToBudget(budgetId, revenueDto);

        return getBudgetDto(budget);
    }

    public BudgetDto addCategoryToBudget(Long id, String categoryName) {
        Budget budget = budgetService.addCategory(id, categoryName);

        return getBudgetDto(budget);
    }

    public BudgetDto getBudget(Long id) {
        Budget budget = budgetService.getBudget(id);

        return getBudgetDto(budget);
    }



    public BudgetDto addExpense(Long budgetId, ExpenseDto expenseDto) {
        Budget budget = budgetService.addExpense(budgetId, expenseDto);

        return getBudgetDto(budget);
    }

    public String generateRaport() {
        reportFacade.generate("weekly");
        return "success";
    }


    private static BudgetDto getBudgetDto(Budget budget) {
        List<CategoryDto> categoryDtos = budget.getCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .toList();

        List<ExpenseDto> expenseDtos = budget.getExpenses().stream()
                .map(expense -> new ExpenseDto(expense.getDescription(), expense.getAmount(), expense.getCategory()))
                .toList();

        List<RevenueDto> revenueDtos = budget.getRevenues().stream()
                .map(revenue -> new RevenueDto(revenue.getSource(), revenue.getAmount()))
                .toList();

        return new BudgetDto.BudgetDtoBuilder()
                .id(budget.getId())
                .name(budget.getName())
                .amount(budget.getAmount())
                .categories(categoryDtos)
                .revenues(revenueDtos)
                .expenses(expenseDtos)
                .build();
    }



}
