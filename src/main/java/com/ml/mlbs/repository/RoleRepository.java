package com.ml.mlbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ml.mlbs.model.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    
}
