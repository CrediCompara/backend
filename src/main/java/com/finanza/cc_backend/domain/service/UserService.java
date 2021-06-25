package com.finanza.cc_backend.domain.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<MortgageCredit> getMortgageCreditsById(Long userId);
    User findUserByEmail(String email);
}
