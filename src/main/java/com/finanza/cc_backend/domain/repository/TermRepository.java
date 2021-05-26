package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<Term, Long> {
}
