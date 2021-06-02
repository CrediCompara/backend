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

    public MortgageCredit setId(Long id) {
        Id = id;
        return this;
    }

    public double getProperty_value() {
        return property_value;
    }

    public MortgageCredit setProperty_value(double property_value) {
        this.property_value = property_value;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public MortgageCredit setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public int getTerm() {
        return term;
    }

    public MortgageCredit setTerm(int term) {
        this.term = term;
        return this;
    }

    public double getIncomes() {
        return incomes;
    }

    public MortgageCredit setIncomes(double incomes) {
        this.incomes = incomes;
        return this;
    }

    public double getFee_value() {
        return fee_value;
    }

    public MortgageCredit setFee_value(double fee_value) {
        this.fee_value = fee_value;
        return this;
    }

    public User getUser() {
        return user;
    }

    public MortgageCredit setUser(User user) {
        this.user = user;
        return this;
    }

    public Rate getRate() {
        return rate;
    }

    public MortgageCredit setRate(Rate rate) {
        this.rate = rate;
        return this;
    }
}