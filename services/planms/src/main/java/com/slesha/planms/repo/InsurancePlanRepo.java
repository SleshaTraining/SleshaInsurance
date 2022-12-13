package com.slesha.planms.repo;

import com.slesha.planms.entity.InsurancePlan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePlanRepo extends JpaRepository<InsurancePlan,Integer>{
    
}
