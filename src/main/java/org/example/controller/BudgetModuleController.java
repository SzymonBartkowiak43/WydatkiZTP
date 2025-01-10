package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.budget_module.BudgetFacade;
import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.RevenueDto;
import org.example.controller.dto.BudgetCreatedDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BudgetModuleController {

    private final BudgetFacade budgetFacade;


    @PostMapping("/budget/create")
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetCreatedDto budgetCreatedDto) {
        try {
            BudgetDto budgetDto = budgetFacade.createBudget(budgetCreatedDto.name());
            return ResponseEntity.status(HttpStatus.CREATED).body(budgetDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/budget/{id}/revenue")
    public ResponseEntity<Long> addRevenue(@PathVariable Long id, @RequestBody RevenueDto revenueDto) {
        Long budgetId = budgetFacade.addRevenue(id, revenueDto);
        return ResponseEntity.ok(budgetId);
    }

    @GetMapping("/report")
    public ResponseEntity<String> generateReport() {
        String report = budgetFacade.generateRaport();
        return ResponseEntity.ok(report);
    }

//    @PostMapping("/budget/{budgetName}/category")
//    public ResponseEntity<BudgetDto> addCategoryToBudget(
//            @PathVariable String budgetName,
//            @RequestParam String categoryName) {
//       // BudgetDto budgetDto = budgetFacade.addCategoryToBudget(budgetName, categoryName);
//        //return ResponseEntity.ok(budgetDto);
//        return null;
//    }
//

//
//    @PostMapping("/budget/{budgetName}/expense")
//    public ResponseEntity<BudgetDto> addExpense(
//            @PathVariable String budgetName,
//            @RequestBody ExpenseDto expenseDto) {
//        BudgetDto budgetDto = budgetFacade.addExpense(budgetName, expenseDto);
//        return ResponseEntity.ok(budgetDto);
//    }

}
