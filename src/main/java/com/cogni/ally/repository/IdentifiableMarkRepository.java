package com.cogni.ally.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cogni.ally.model.IdentifiableMark;

@Repository
public interface IdentifiableMarkRepository extends JpaRepository<IdentifiableMark, Long>{
	Set<IdentifiableMark> findByUnicornUnicornId(Long unicornId);
}