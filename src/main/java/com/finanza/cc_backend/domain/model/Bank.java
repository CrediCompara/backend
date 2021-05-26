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

   public void setId(Long id) {
      Id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Rate> getRates() {
      return rates;
   }

   public void setRates(List<Rate> rates) {
      this.rates = rates;
   }
}
