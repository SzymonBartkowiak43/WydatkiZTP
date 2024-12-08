package org.example.budget_module;

import org.example.budget_module.dto.BudgetDto;
import org.example.budget_module.dto.ExpenseDto;
import org.example.budget_module.dto.RevenueDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

//class ReportFacadeTest {
//
//    @Mock
//    private BudgetService budgetService;
//
//    @InjectMocks
//    private BudgetFacade reportFacade;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void addCategoryToBudget_shouldAddCategorySuccessfully() {
//        // Given
//        String budgetName = "My Budget";
//        String categoryName = "Groceries";
//        Category category = new Category(categoryName);
//        Budget budget = new Budget(budgetName, BigDecimal.ZERO);
//        budget.addCategory(categoryName);
//
//        when(budgetService.addCategoryToBudget(budgetName, categoryName)).thenReturn(Optional.of(category));
//        when(budgetService.createBudget(budgetName, BigDecimal.ZERO)).thenReturn(budget);
//
//        // When
//        BudgetDto result = reportFacade.addCategoryToBudget(budgetName, categoryName);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result.getName()).isEqualTo(budgetName);
//        assertThat(result.getCategories()).containsExactly(categoryName);
//
//        verify(budgetService).addCategoryToBudget(budgetName, categoryName);
//        verify(budgetService).createBudget(budgetName, BigDecimal.ZERO);
//    }
//
//    @Test
//    void addCategoryToBudget_shouldThrowExceptionIfCategoryExists() {
//        // Given
//        String budgetName = "My Budget";
//        String categoryName = "Groceries";
//
//        when(budgetService.addCategoryToBudget(budgetName, categoryName))
//                .thenReturn(Optional.empty());
//
//        // When & Then
//        assertThatThrownBy(() -> reportFacade.addCategoryToBudget(budgetName, categoryName))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("Category with this name already exists!");
//
//        verify(budgetService).addCategoryToBudget(budgetName, categoryName);
//        verifyNoMoreInteractions(budgetService);
//    }
//
//    @Test
//    void addRevenue_shouldAddRevenueSuccessfully() {
//        // Given
//        String budgetName = "My Budget";
//        RevenueDto revenueDto = new RevenueDto("Salary", BigDecimal.valueOf(5000));
//        Revenue revenue = new Revenue(revenueDto.getSource(), revenueDto.getAmount());
//        Budget budget = new Budget(budgetName, BigDecimal.ZERO);
//
//        when(budgetService.createBudget(budgetName, BigDecimal.ZERO)).thenReturn(budget);
//
//        // When
//        BudgetDto result = reportFacade.addRevenue(budgetName, revenueDto);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result.getName()).isEqualTo(budgetName);
//        assertThat(result.getAmount()).isEqualTo(BigDecimal.ZERO);
//
//        verify(budgetService).addRevenueToBudget(budgetName, revenue);
//        verify(budgetService).createBudget(budgetName, BigDecimal.ZERO);
//    }
//
//    @Test
//    void addExpense_shouldAddExpenseSuccessfully() {
//        // Given
//        String budgetName = "My Budget";
//        ExpenseDto expenseDto = new ExpenseDto("Rent", BigDecimal.valueOf(1000));
//        Expense expense = new Expense(expenseDto.getDescription(), expenseDto.getAmount());
//        Budget budget = new Budget(budgetName, BigDecimal.ZERO);
//
//        when(budgetService.createBudget(budgetName, BigDecimal.ZERO)).thenReturn(budget);
//
//        // When
//        BudgetDto result = reportFacade.addExpense(budgetName, expenseDto);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result.getName()).isEqualTo(budgetName);
//        assertThat(result.getAmount()).isEqualTo(BigDecimal.ZERO);
//
//        verify(budgetService).addExpenseToBudget(budgetName, expense);
//        verify(budgetService).createBudget(budgetName, BigDecimal.ZERO);
//    }
//}
