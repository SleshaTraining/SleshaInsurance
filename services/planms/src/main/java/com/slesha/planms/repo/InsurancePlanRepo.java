package com.slesha.planms.repo;

import com.slesha.planms.entity.InsurancePlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePlanRepo extends JpaRepository<InsurancePlan,Integer>{
    
}
