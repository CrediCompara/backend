package com.finanza.cc_backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rates")
public class Rate extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //ManyToOne bank
    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    //ManyToOne term
    @ManyToOne
    @JoinColumn(name = "term_id", nullable = false)
    private Term term;

    //ManyToOne value
    @ManyToOne
    @JoinColumn(name = "value_id", nullable = false)
    private Value value;

    //OneToOne
    @OneToOne(mappedBy = "bank")
    @JsonIgnore
    private MortgageCredit mortgageCredit;

    @NotNull
    private double min_rate;

    @NotNull
    private double max_rate;

    public Long getId() {
        return Id;
    }

    public Rate setId(Long id) {
        Id = id;
        return this;
    }

    public Bank getBank() {
        return bank;
    }

    public Rate setBank(Bank bank) {
        this.bank = bank;
        return this;
    }

    public Term getTerm() {
        return term;
    }

    public Rate setTerm(Term term) {
        this.term = term;
        return this;
    }

    public Value getValue() {
        return value;
    }

    public Rate setValue(Value value) {
        this.value = value;
        return this;
    }

    public MortgageCredit getMortgageCredit() {
        return mortgageCredit;
    }

    public Rate setMortgageCredit(MortgageCredit mortgageCredit) {
        this.mortgageCredit = mortgageCredit;
        return this;
    }

    public double getMin_rate() {
        return min_rate;
    }

    public Rate setMin_rate(double min_rate) {
        this.min_rate = min_rate;
        return this;
    }

    public double getMax_rate() {
        return max_rate;
    }

    public Rate setMax_rate(double max_rate) {
        this.max_rate = max_rate;
        return this;
    }
}