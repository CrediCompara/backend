package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Rate;
import com.finanza.cc_backend.domain.model.Term;
import com.finanza.cc_backend.domain.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {
    List<Rate> findByTermAndValue(Term term, Value value);
}
