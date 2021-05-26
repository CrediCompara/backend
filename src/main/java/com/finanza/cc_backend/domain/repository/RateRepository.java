package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {
}
