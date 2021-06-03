package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.MortgageCreditRepository;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MortgageCreditRepository mortagageCreditRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public MortgageCredit getMortgageCredit(Long id) {
         return mortagageCreditRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("MortgageCredit","Id",id));

    }


}
