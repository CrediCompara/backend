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

    //OneToMany rates
    @OneToMany(mappedBy = "value")
    @JsonIgnore
    private List<Rate> rates;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getMin_value() {
        return min_value;
    }

    public void setMin_value(double min_value) {
        this.min_value = min_value;
    }

    public double getMax_value() {
        return max_value;
    }

    public void setMax_value(double max_value) {
        this.max_value = max_value;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
