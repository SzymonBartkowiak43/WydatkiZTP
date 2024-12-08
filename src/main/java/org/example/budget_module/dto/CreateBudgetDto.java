package org.example.budget_module.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateBudgetDto(String name, BigDecimal startAmount) {
}
