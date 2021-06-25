package com.finanza.cc_backend.resource;

import com.finanza.cc_backend.domain.AuditModel;

public class UserResource{

    private Long Id;
    private String first_name;
    private String last_name;
    private String email;

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
}
