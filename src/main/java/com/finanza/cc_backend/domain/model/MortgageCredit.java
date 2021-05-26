package com.finanza.cc_backend.domain.model;

import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mortgage_credits")
public class MortgageCredit extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private double property_value;

    @NotNull
    private String currency;

    @NotNull
    private double initial_free;

    @NotNull
    private int term;

    @NotNull
    private double incomes;

    @NotNull
    private double fee_value;

    //ManyToOne user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //OnetoOne rates
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rate_id", referencedColumnName = "id")
    private Rate rate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getProperty_value() {
        return property_value;
    }

    public void setProperty_value(double property_value) {
        this.property_value = property_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getInitial_free() {
        return initial_free;
    }

    public void setInitial_free(double initial_free) {
        this.initial_free = initial_free;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    public double getFee_value() {
        return fee_value;
    }

    public void setFee_value(double fee_value) {
        this.fee_value = fee_value;
    }
}