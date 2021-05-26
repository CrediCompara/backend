package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.MortgageCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageCreditRepository extends JpaRepository<MortgageCredit, Long> {
}
