package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Long> {
}
