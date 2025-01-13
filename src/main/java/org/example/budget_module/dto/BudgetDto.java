package org.example.budget_module.dto;

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

    public BudgetDto(BudgetDtoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.amount = builder.amount;
        this.categories = builder.categories;
        this.revenues = builder.revenues;
        this.expenses = builder.expenses;
    }



    public static class BudgetDtoBuilder {
        private Long id;
        private String name;
        private BigDecimal amount;
        private List<CategoryDto> categories = new ArrayList<>();
        private List<RevenueDto> revenues = new ArrayList<>();
        private List<ExpenseDto> expenses = new ArrayList<>();

        public BudgetDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BudgetDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BudgetDtoBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public BudgetDtoBuilder categories(List<CategoryDto> categories) {
            this.categories = categories != null ? categories : new ArrayList<>();
            return this;
        }

        public BudgetDtoBuilder revenues(List<RevenueDto> revenues) {
            this.revenues = revenues != null ? revenues : new ArrayList<>();
            return this;
        }

        public BudgetDtoBuilder expenses(List<ExpenseDto> expenses) {
            this.expenses = expenses != null ? expenses : new ArrayList<>();
            return this;
        }

        public BudgetDto build() {
            return new BudgetDto(this);
        }
    }
}