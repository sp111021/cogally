package com.cogni.ally.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogni.ally.model.Unicorn;

@Repository
public interface UnicornRepository extends JpaRepository<Unicorn, Long>{
}