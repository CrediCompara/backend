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
    private double fee_value;

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

    public double getFee_value() {
        return fee_value;
    }

    public SaveMortgageCreditResource setFee_value(double fee_value) {
        this.fee_value = fee_value;
        return this;
    }
}
