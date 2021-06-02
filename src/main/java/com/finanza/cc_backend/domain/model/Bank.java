package com.finanza.cc_backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "banks")
public class Bank extends AuditModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;

   @NotNull
   private String name;

   //OneToMany rates
   @OneToMany(mappedBy = "bank")
   @JsonIgnore
   private List<Rate> rates;

   public Long getId() {
      return Id;
   }

   public Bank setId(Long id) {
      Id = id;
      return this;
   }

   public String getName() {
      return name;
   }

   public Bank setName(String name) {
      this.name = name;
      return this;
   }

   public List<Rate> getRates() {
      return rates;
   }

   public Bank setRates(List<Rate> rates) {
      this.rates = rates;
      return this;
   }
}
