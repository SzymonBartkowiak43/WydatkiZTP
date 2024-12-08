package org.example.budget_module;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BudgetRepository extends CrudRepository<Budget, Long> {
    Optional<Budget> findByName(String name);
}