package org.example.budget_module;

import lombok.AllArgsConstructor;
import org.example.budget_module.dto.RevenueDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
class BudgetService {

    private final BudgetRepository budgetRepository;

    Budget createBudget(String name) {
        budgetRepository.findByName(name).ifPresent(budget -> {
            throw new IllegalArgumentException("Budget with the name " + name + " already exists.");
        });

        Budget newBudget = new Budget(name, BigDecimal.ZERO);
        return budgetRepository.save(newBudget);
    }


    Long addRevenueToBudget(Long budgetId, RevenueDto revenueDto) {
        Budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new RuntimeException("Budget not found!"));

        Revenue revenue = new Revenue(null, revenueDto.getSource(), revenueDto.getAmount(), LocalDate.now(), budget);


        budget.addRevenue(revenue);
        budget.addAmount(revenueDto.getAmount());

        budgetRepository.save(budget);
        return budgetId;
    }








//    public Optional<Category> addCategoryToBudget(String budgetName, String categoryName) {
//        Budget budget = budgetRepository.findByName(budgetName)
//                .orElseThrow(() -> new RuntimeException("Budget not found!"));
//        return budget.addCategory(categoryName);
//    }
//
//    public void addExpenseToBudget(String budgetName, Expense expense) {
//        Budget budget = budgetRepository.findByName(budgetName)
//                .orElseThrow(() -> new RuntimeException("Budget not found!"));
//        budget.addExpense(expense);
//        budgetRepository.save(budget);
//    }
}