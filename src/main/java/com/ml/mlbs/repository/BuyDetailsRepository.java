package com.ml.mlbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ml.mlbs.model.BuyDetails;

public interface BuyDetailsRepository extends JpaRepository<BuyDetails, Long>{
    
}
