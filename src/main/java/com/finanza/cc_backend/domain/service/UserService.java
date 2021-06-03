package com.finanza.cc_backend.domain.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;

public interface UserService {
    User createUser(User user);
    MortgageCredit getMortgageCredit (Long id);
}
