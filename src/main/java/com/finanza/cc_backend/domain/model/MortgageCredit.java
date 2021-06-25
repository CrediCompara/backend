package com.finanza.cc_backend.domain.model;

import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
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
    private double initial_fee;

    @NotNull
    private double monthly_fee;

    @NotNull
    private double tcea;

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

    public double getInitial_fee() {
        return initial_fee;
    }

    public MortgageCredit setInitial_fee(double initial_fee) {
        this.initial_fee = initial_fee;
        return this;
    }

    public double getMonthly_fee() {
        return monthly_fee;
    }

    public MortgageCredit setMonthly_fee(double monthly_fee) {
        this.monthly_fee = monthly_fee;
        return this;
    }

    public double getTcea() {
        return tcea;
    }

    public MortgageCredit setTcea(double tcea) {
        this.tcea = tcea;
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