package com.finanza.cc_backend.service;

import com.finanza.cc_backend.domain.model.User;
import com.finanza.cc_backend.domain.repository.UserRepository;
import com.finanza.cc_backend.domain.service.UserService;
import com.finanza.cc_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        User existingUsername = userRepository.findCustomerByUsername(user.getUsername()).orElse(null);
        if (existingUsername != null){
            throw new ResourceNotFoundException("This username is begin used by another user");
        }
        User existingEmail = userRepository.findCustomerByEmail(user.getEmail()).orElse(null);
        if (existingEmail != null){
            throw new ResourceNotFoundException("This email is begin used by another user");
        }
        User existingPhone = userRepository.findCustomerByPhone(user.getPhone()).orElse(null);
        if (existingPhone != null){
            throw new ResourceNotFoundException("This phone number is begin used by another user");
        }
        return userRepository.save(user);
    }
}
