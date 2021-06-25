package com.finanza.cc_backend.service.communication;

import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.resource.UserResource;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private UserResource user;
    private String token;

    public AuthenticationResponse(UserResource user, String token) {
        this.user = user;
        this.token = token;
    }
    public UserResource getUser() {
        return user;
    }

    public AuthenticationResponse setUser(UserResource user) {
        this.user = user;
        return this;
    }

    public String getToken() {
        return token;
    }

    public AuthenticationResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
