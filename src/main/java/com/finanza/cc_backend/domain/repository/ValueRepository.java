package com.finanza.cc_backend.domain.repository;

import com.finanza.cc_backend.domain.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ValueRepository extends JpaRepository<Value, Long> {
     @Query("select v from Value v where v.min_value <= :value and v.max_value >= :value and v.currency = :currency")
     List<Value> getValueBasedOnPValue(@Param("value") double value, @Param("currency") String currency);
}
