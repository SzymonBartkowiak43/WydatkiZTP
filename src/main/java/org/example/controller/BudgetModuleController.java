package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.budget_module.BudgetFacade;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.CreateCategory;
import org.example.budget_module.dto.ExpenseDto;
import org.example.budget_module.dto.RevenueDto;
import org.example.controller.dto.BudgetCreatedDto;
import org.example.report_module.dto.CreateReportDto;
import org.example.report_module.dto.ReportDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BudgetModuleController {

    private final BudgetFacade budgetFacade;

    @GetMapping("/budget/{id}")
    public ResponseEntity<BudgetDto> getBudget(@PathVariable Long id) {
        BudgetDto budgetDto =  budgetFacade.getBudget(id);

        return ResponseEntity.ok(budgetDto);
    }

    @PostMapping("/budget/create")
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetCreatedDto budgetCreatedDto) {
        try {
            BudgetDto budgetDto = budgetFacade.createBudget(budgetCreatedDto.name(), budgetCreatedDto.amount());
            return ResponseEntity.status(HttpStatus.CREATED).body(budgetDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/budget/{id}/revenue")
    public ResponseEntity<BudgetDto> addRevenue(@PathVariable Long id, @RequestBody RevenueDto revenueDto) {
        BudgetDto budgetDto = budgetFacade.addRevenue(id, revenueDto);
        return ResponseEntity.ok(budgetDto);
    }

    @PostMapping("/budget/{id}/category")
    public ResponseEntity<BudgetDto> addCategoryToBudget(
            @PathVariable Long id,
            @RequestBody  CreateCategory categoryName) {
        BudgetDto budgetDto = budgetFacade.addCategoryToBudget(id, categoryName.name());
        return ResponseEntity.ok(budgetDto);
    }


    @PostMapping("/budget/{id}/expense")
    public ResponseEntity<BudgetDto> addExpense(
            @PathVariable Long id,
            @RequestBody ExpenseDto expenseDto) {
        BudgetDto budgetDto = budgetFacade.addExpense(id, expenseDto);
        return ResponseEntity.ok(budgetDto);
    }

    @GetMapping("/{id}/report")
    public ResponseEntity<ReportDto> generateReport(@PathVariable Long id,
                                                    @RequestBody CreateReportDto createReportDto) {
        ReportDto report = budgetFacade.generateReport(createReportDto,id);
        return ResponseEntity.ok(report);
    }

}
