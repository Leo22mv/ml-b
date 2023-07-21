package com.ml.mlbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ml.mlbs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}