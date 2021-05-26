package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
