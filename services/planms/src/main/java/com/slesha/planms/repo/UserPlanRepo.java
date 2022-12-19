package com.slesha.planms.repo;

import com.slesha.planms.entity.UserPlan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlanRepo extends JpaRepository<UserPlan,Integer>{
    
}
