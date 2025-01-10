package org.example.budget_module;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@Entity
class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private BigDecimal amount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "budget")
    private List<Category> categories = new LinkedList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "budget")
    private List<Revenue> revenues = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "budget")
    private List<Expense> expenses = new ArrayList<>();

    public Budget(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public Budget() {
    }

    void addRevenue(Revenue revenue) {
        revenue.setBudget(this);
        revenues.add(revenue);
    }

    void addAmount(BigDecimal bigDecimal) {
        this.amount = this.amount.add(bigDecimal);
    }

    Optional<Category> addCategory(String categoryName) {
        boolean exists = categories.stream().anyMatch(c -> c.getName().equalsIgnoreCase(categoryName));
        if (exists) {
            return Optional.empty();
        }
        Category category = new Category(categoryName);
        category.setBudget(this);
        categories.add(category);
        return Optional.of(category);
    }
//
//
//    void addExpense(Expense expense) {
//        expense.setBudget(this);
//        expenses.add(expense);
//    }
}
