package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findCustomerByEmail(String email);
    Optional<User> findCustomerByUsername(String username);
    Optional<User> findCustomerByPhone(String phone);
}
