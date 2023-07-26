package com.ml.mlbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ml.mlbs.model.Buy;

public interface BuyRepository extends JpaRepository<Buy, Long>{
    
}
