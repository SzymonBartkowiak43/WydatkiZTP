package org.example.controller.dto;

import java.math.BigDecimal;

public record BudgetCreatedDto(String name, BigDecimal amount) {
}
