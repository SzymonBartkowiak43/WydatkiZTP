package org.example.budget_module;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
