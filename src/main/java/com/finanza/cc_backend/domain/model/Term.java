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

    public void setId(Long id) {
        Id = id;
    }

    public double getMin_term() {
        return min_term;
    }

    public void setMin_term(double min_term) {
        this.min_term = min_term;
    }

    public double getMax_term() {
        return max_term;
    }

    public void setMax_term(double max_term) {
        this.max_term = max_term;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }
}
