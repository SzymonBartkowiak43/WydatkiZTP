package org.example.budget_module.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BudgetDto {
    private Long id;
    private String name;
    private BigDecimal amount;
    private List<CategoryDto> categories;
    private List<RevenueDto> revenues;
    private List<ExpenseDto> expenses;

    public BudgetDto(Long id,String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.categories = new ArrayList<>();
        this.revenues = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public BudgetDto(Long id,String name, BigDecimal amount, List<CategoryDto> categories) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.categories = categories;
        this.revenues = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
}