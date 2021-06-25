package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.MortgageCreditRepository;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.MortgageCreditService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageCreditServiceImpl implements MortgageCreditService {
    @Autowired
    MortgageCreditRepository mortgageCreditRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveMortgageCreditByUserId(MortgageCredit mortgageCredit, Long userId) {
        MortgageCredit mortgageCredit1 = mortgageCreditRepository.save(mortgageCredit);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.getMortgageCreditsList().add(mortgageCredit1);
        return user;
    }
}
