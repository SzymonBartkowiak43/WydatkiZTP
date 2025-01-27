package org.example.budget_module;

import lombok.AllArgsConstructor;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.budget_module.dto.RevenueDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
class BudgetService {

    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;

    Budget createBudget(String name, BigDecimal amount) {
        budgetRepository.findByName(name).ifPresent(budget -> {
            throw new IllegalArgumentException("Budget with the name " + name + " already exists.");
        });

        Budget newBudget = new Budget(name, amount);
        return budgetRepository.save(newBudget);
    }


    Budget addRevenueToBudget(Long budgetId, RevenueDto revenueDto) {
        Budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new RuntimeException("Budget not found!"));

        Revenue revenue = new Revenue(null, revenueDto.getSource(), revenueDto.getAmount(), LocalDate.now(), budget);


        budget.addRevenue(revenue);
        budget.addAmount(revenueDto.getAmount());

        Budget save = budgetRepository.save(budget);
        return save;
    }

    Budget addCategory(Long id, String categoryName) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found"));

        Optional<Category> addedCategory = budget.addCategory(categoryName);
        if (addedCategory.isEmpty()) {
            System.out.println(";c");
        }

        categoryRepository.save(addedCategory.get());
        Budget save = budgetRepository.save(budget);

        return save;
    }

    public Budget getBudget(Long id) {
        return budgetRepository.findById(id).get();
    }

    public Budget addExpense(Long budgetId, ExpenseDto expenseDto) {
        Budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found"));

        Category category = budget.getCategories().stream()
                .filter(cat -> cat.getName().equals(expenseDto.getCategory()))
                .findFirst()
                .orElseGet(() -> {
                    Category newCategory = new Category(expenseDto.getCategory());
                    budget.addCategory(newCategory.getName());
                    return categoryRepository.save(newCategory);
                });

        Expense expense = new Expense(
                expenseDto.getDescription(),
                expenseDto.getAmount(),
                category.getName(),
                expenseDto.getDate()
        );

        expense.setBudget(budget);
        expenseRepository.save(expense);

        budget.addExpense(expenseDto.getAmount());

        return budgetRepository.save(budget);
    }

}