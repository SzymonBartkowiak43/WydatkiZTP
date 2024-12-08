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
    private LocalDate date;

    public ExpenseDto(String description, BigDecimal amount, LocalDate localDate) {
        this.description = description;
        this.amount = amount;
        this.date = localDate;
    }
}