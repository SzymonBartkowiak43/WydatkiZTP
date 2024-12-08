package org.example.budget_module.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseDto {
    private String description;
    private BigDecimal amount;

    public ExpenseDto(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
    }
}