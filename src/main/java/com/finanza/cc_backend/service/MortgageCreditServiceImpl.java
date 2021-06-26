package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.MortgageCreditRepository;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.MortgageCreditService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MortgageCreditServiceImpl implements MortgageCreditService {
    @Autowired
    MortgageCreditRepository mortgageCreditRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public MortgageCredit saveMortgageCreditByUserId(MortgageCredit mortgageCredit, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        mortgageCredit.setUser(user);
        MortgageCredit mortgageCredit1 = mortgageCreditRepository.save(mortgageCredit);
        user.getMortgageCreditsList().add(mortgageCredit1);
        return mortgageCredit1;
    }

    @Override
    public void deleteMortgageById(Long mortgageId) {
        MortgageCredit mc = mortgageCreditRepository.findById(mortgageId)
                .orElseThrow(() -> new ResourceNotFoundException("Mortgage Credit", "Id", mortgageId));
        mortgageCreditRepository.delete(mc);
    }
}
