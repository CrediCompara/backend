package com.finanza.cc_backend.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveMortgageCreditResource {
    @NotNull
    private double property_value;

    @NotNull
    @NotBlank
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

    public double getProperty_value() {
        return property_value;
    }

    public SaveMortgageCreditResource setProperty_value(double property_value) {
        this.property_value = property_value;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public SaveMortgageCreditResource setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public int getTerm() {
        return term;
    }

    public SaveMortgageCreditResource setTerm(int term) {
        this.term = term;
        return this;
    }

    public double getIncomes() {
        return incomes;
    }

    public SaveMortgageCreditResource setIncomes(double incomes) {
        this.incomes = incomes;
        return this;
    }

    public double getInitial_fee() {
        return initial_fee;
    }

    public SaveMortgageCreditResource setInitial_fee(double initial_fee) {
        this.initial_fee = initial_fee;
        return this;
    }

    public double getMonthly_fee() {
        return monthly_fee;
    }

    public SaveMortgageCreditResource setMonthly_fee(double monthly_fee) {
        this.monthly_fee = monthly_fee;
        return this;
    }

    public double getTcea() {
        return tcea;
    }

    public SaveMortgageCreditResource setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }
}
