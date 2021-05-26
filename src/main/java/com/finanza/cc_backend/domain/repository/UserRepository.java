package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
