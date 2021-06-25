package com.finanza.cc_backend.resource;

import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


public class MortgageCreditResource extends AuditModel {
    private Long Id;
    private double property_value;
    private String currency;
    private int term;
    private double incomes;
    private double initial_fee;
    private double monthly_fee;
    private double tcea;

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

    public double getInitial_fee() {
        return initial_fee;
    }

    public MortgageCreditResource setInitial_fee(double initial_fee) {
        this.initial_fee = initial_fee;
        return this;
    }

    public double getMonthly_fee() {
        return monthly_fee;
    }

    public MortgageCreditResource setMonthly_fee(double monthly_fee) {
        this.monthly_fee = monthly_fee;
        return this;
    }

    public double getTcea() {
        return tcea;
    }

    public MortgageCreditResource setTcea(double tcea) {
        this.tcea = tcea;
        return this;
    }
}
