package com.finanza.cc_backend.domain.model;

import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;

    //OneToMay mortgage_credits
    @OneToMany(mappedBy = "user")
    private List<MortgageCredit> mortgageCreditsList;

    public Long getId() {
        return Id;
    }

    public User setId(Long id) {
        Id = id;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public User setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public User setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<MortgageCredit> getMortgageCreditsList() {
        return mortgageCreditsList;
    }

    public User setMortgageCreditsList(List<MortgageCredit> mortgageCreditsList) {
        this.mortgageCreditsList = mortgageCreditsList;
        return this;
    }
}