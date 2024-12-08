package org.example.budget_module.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class RevenueDto {
    private String source;
    private BigDecimal amount;

    public RevenueDto(String source, BigDecimal amount) {
        this.source = source;
        this.amount = amount;

    }
}