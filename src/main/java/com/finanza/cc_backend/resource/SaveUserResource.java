package com.finanza.cc_backend.resource;

import com.finanza.cc_backend.domain.AuditModel;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveUserResource {
    @NotNull
    @NotBlank
    private String first_name;

    @NotNull
    @NotBlank
    private String last_name;

    @NotNull
    @Column(unique = true)
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String phone;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    private String password;

    public String getFirst_name() {
        return first_name;
    }

    public SaveUserResource setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public SaveUserResource setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SaveUserResource setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SaveUserResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
