package com.finanza.cc_backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "property_values")
public class Value extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private double min_value;

    @NotNull
    private double max_value;

    @NotNull
    private String currency;

    //OneToMany rates
    @OneToMany(mappedBy = "value")
    @JsonIgnore
    private List<Rate> rates;

    public Long getId() {
        return Id;
    }

    public Value setId(Long id) {
        Id = id;
        return this;
    }

    public double getMin_value() {
        return min_value;
    }

    public Value setMin_value(double min_value) {
        this.min_value = min_value;
        return this;
    }

    public double getMax_value() {
        return max_value;
    }

    public Value setMax_value(double max_value) {
        this.max_value = max_value;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Value setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public Value setRates(List<Rate> rates) {
        this.rates = rates;
        return this;
    }
}