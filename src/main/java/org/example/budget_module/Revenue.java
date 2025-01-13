package org.example.budget_module;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Entity
@Getter
class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String source;
    private BigDecimal amount;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    public Revenue(Long id, String source, BigDecimal amount, LocalDate date, Budget budget) {
        this.id = id;
        this.source = source;
        this.amount = amount;
        this.date = date;
        this.budget = budget;
    }

    public Revenue() {
    }
}