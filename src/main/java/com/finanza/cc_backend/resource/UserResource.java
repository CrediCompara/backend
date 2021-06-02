package com.finanza.cc_backend.resource;

import com.finanza.cc_backend.domain.AuditModel;

public class UserResource extends AuditModel {

    private Long Id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public Long getId() {
        return Id;
    }

    public UserResource setId(Long id) {
        Id = id;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public UserResource setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public UserResource setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserResource setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
