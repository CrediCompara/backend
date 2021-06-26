package com.finanza.cc_backend.domain.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface MortgageCreditService {
    MortgageCredit saveMortgageCreditByUserId(MortgageCredit mortgageCredit, Long UserId);
    void deleteMortgageById(Long mortgageId);
}
