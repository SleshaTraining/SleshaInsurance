package com.slesha.planms.repo;

import com.slesha.planms.entity.UserPlan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPlanRepo extends JpaRepository<UserPlan,Integer>{

    @Query("select up from UserPlan up where up.user.emailId=?1")
    public List<UserPlan> findByEmailId(String emailId);
}
