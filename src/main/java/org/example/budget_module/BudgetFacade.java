package org.example.budget_module;

import lombok.AllArgsConstructor;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.RevenueDto;
import org.springframework.stereotype.Component;



@AllArgsConstructor
@Component
public class BudgetFacade {

    private final BudgetService budgetService;

    public Long createBudget(String name) {
        Budget budget = budgetService.createBudget(name);

        bu


        return BudgetDto.builder()
                .name(budget.getName())
                .amount(budget.getAmount())
                .expenses(budget.getExpenses())
                .build()
    }

    public Long addRevenue(Long budgetId, RevenueDto revenueDto) {
        budgetService.addRevenueToBudget(budgetId, revenueDto);
        return budgetId;
    }

//    public BudgetDto addCategoryToBudget(String budgetName, String categoryName) {
//        Category category = budgetService.addCategoryToBudget(budgetName, categoryName)
//                .orElseThrow(() -> new RuntimeException("Category with this name already exists!"));
//
//        Budget budget = budgetService.createBudget(budgetName, BigDecimal.ZERO);
//        BudgetDto budgetDto = new BudgetDto(budget.getName(), budget.getAmount());
//        budget.getCategories().forEach(c -> budgetDto.getCategories().add(c.getName()));
//        return budgetDto;
//    }
//

//
//    public BudgetDto addExpense(String budgetName, ExpenseDto expenseDto) {
//        Expense expense = new Expense(expenseDto.getDescription(), expenseDto.getAmount());
//        budgetService.addExpenseToBudget(budgetName, expense);
//
//        Budget budget = budgetService.createBudget(budgetName, BigDecimal.ZERO);
//        return new BudgetDto(budget.getName(), budget.getAmount());
//    }


}
