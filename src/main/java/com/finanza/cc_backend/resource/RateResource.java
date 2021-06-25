package com.finanza.cc_backend.resource;

public class RateResource {
    private Long Id;
    private Long bank_id;
    private Long term_id;
    private Long value_id;
    private double min_rate;
    private double max_rate;

    public Long getId() {
        return Id;
    }

    public RateResource setId(Long id) {
        Id = id;
        return this;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public RateResource setBank_id(Long bank_id) {
        this.bank_id = bank_id;
        return this;
    }

    public Long getTerm_id() {
        return term_id;
    }

    public RateResource setTerm_id(Long term_id) {
        this.term_id = term_id;
        return this;
    }

    public Long getValue_id() {
        return value_id;
    }

    public RateResource setValue_id(Long value_id) {
        this.value_id = value_id;
        return this;
    }

    public double getMin_rate() {
        return min_rate;
    }

    public RateResource setMin_rate(double min_rate) {
        this.min_rate = min_rate;
        return this;
    }

    public double getMax_rate() {
        return max_rate;
    }

    public RateResource setMax_rate(double max_rate) {
        this.max_rate = max_rate;
        return this;
    }
}
