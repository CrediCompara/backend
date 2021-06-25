package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TermRepository extends JpaRepository<Term, Long> {
    @Query("select t from Term t where t.min_term <= :term and t.max_term >= :term")
    List<Term> getTermBasedOnTermValue(@Param("term") double term);
}
