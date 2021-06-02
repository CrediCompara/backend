package com.finanza.cc_backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "terms")
public class Term extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private double min_term;

    @NotNull
    private double max_term;

    @OneToMany(mappedBy = "term")
    @JsonIgnore
    private List<Rate> rateList;

    public Long getId() {
        return Id;
    }

    public Term setId(Long id) {
        Id = id;
        return this;
    }

    public double getMin_term() {
        return min_term;
    }

    public Term setMin_term(double min_term) {
        this.min_term = min_term;
        return this;
    }

    public double getMax_term() {
        return max_term;
    }

    public Term setMax_term(double max_term) {
        this.max_term = max_term;
        return this;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public Term setRateList(List<Rate> rateList) {
        this.rateList = rateList;
        return this;
    }
}