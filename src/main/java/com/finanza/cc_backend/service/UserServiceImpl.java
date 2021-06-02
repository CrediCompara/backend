package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }
}
