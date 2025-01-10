package org.example.budget_module;

import lombok.AllArgsConstructor;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.RevenueDto;
import org.example.report_module.ReportFacade;
import org.springframework.stereotype.Component;



@AllArgsConstructor
@Component
public class BudgetFacade {

    private final BudgetService budgetService;
    private final ReportFacade reportFacade = ReportFacade.getInstance();

    public BudgetDto createBudget(String name) {
        Budget budget = budgetService.createBudget(name);

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount());
    }

    public Long addRevenue(Long budgetId, RevenueDto revenueDto) {
        Long l = budgetService.addRevenueToBudget(budgetId, revenueDto);
        return budgetId;
    }

    public String generateRaport() {
        reportFacade.generate("weekly");
        return "success";
    }

    public BudgetDto addCategoryToBudget(Long id, String categoryName) {
        Budget budget = budgetService.addCategory(id, categoryName);

        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount());
    }

    public BudgetDto getBudget(Long id) {
        Budget budget = budgetService.getBudget(id);
        return new BudgetDto(budget.getId(), budget.getName(), budget.getAmount());
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
