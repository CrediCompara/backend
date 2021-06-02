package com.finanza.cc_backend.resource;

import com.finanza.cc_backend.domain.AuditModel;


public class MortgageCreditResource extends AuditModel {
    private Long Id;
    private double property_value;
    private String currency;
    private int term;
    private double incomes;
    private double fee_value;

    public Long getId() {
        return Id;
    }

    public MortgageCreditResource setId(Long id) {
        Id = id;
        return this;
    }

    public double getProperty_value() {
        return property_value;
    }

    public MortgageCreditResource setProperty_value(double property_value) {
        this.property_value = property_value;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public MortgageCreditResource setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public int getTerm() {
        return term;
    }

    public MortgageCreditResource setTerm(int term) {
        this.term = term;
        return this;
    }

    public double getIncomes() {
        return incomes;
    }

    public MortgageCreditResource setIncomes(double incomes) {
        this.incomes = incomes;
        return this;
    }

    public double getFee_value() {
        return fee_value;
    }

    public MortgageCreditResource setFee_value(double fee_value) {
        this.fee_value = fee_value;
        return this;
    }
}
