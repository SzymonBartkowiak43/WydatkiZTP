package org.example.budget_module;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;
    private BigDecimal amount;
    private String category;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public Expense(String description, BigDecimal amount, String category, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public Expense() {
    }
}
