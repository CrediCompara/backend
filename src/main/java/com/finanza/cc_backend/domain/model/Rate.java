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
    @OneToOne(mappedBy = "rate")
    @JsonIgnore
    private MortgageCredit mortgageCredit;

    @NotNull
    private double min_rate;

    @NotNull
    private double max_rate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public MortgageCredit getMortgageCredit() {
        return mortgageCredit;
    }

    public void setMortgageCredit(MortgageCredit mortgageCredit) {
        this.mortgageCredit = mortgageCredit;
    }

    public double getMin_rate() {
        return min_rate;
    }

    public void setMin_rate(double min_rate) {
        this.min_rate = min_rate;
    }

    public double getMax_rate() {
        return max_rate;
    }

    public void setMax_rate(double max_rate) {
        this.max_rate = max_rate;
    }
}