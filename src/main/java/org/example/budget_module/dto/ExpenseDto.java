package org.example.budget_module.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ExpenseDto {
    private String description;
    private BigDecimal amount;
    private String category;

    public ExpenseDto(String description, BigDecimal amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}