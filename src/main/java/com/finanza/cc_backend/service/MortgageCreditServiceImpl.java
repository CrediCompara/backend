package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.Bank;
import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.BankRepository;
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

    @Autowired
    BankRepository bankRepository;

    @Override
    public MortgageCredit saveMortgageCreditByUserId(MortgageCredit mortgageCredit, Long userId,Long bank_id) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        Bank bank = bankRepository.findById(bank_id).orElseThrow(()-> new ResourceNotFoundException("Bank", "Id",bank_id));
        mortgageCredit.setBank(bank);
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
