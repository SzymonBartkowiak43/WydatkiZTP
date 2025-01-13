package org.example.report_module.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.budget_module.dto.ExpenseDto;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class ReportDto {
    private List<ExpenseDto> expenses;
    private BigDecimal totalAmount;
}
