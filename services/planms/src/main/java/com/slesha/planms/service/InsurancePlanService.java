package com.slesha.planms.service;

import java.util.List;
import java.util.Optional;

import com.slesha.planms.entity.InsurancePlan;
import com.slesha.planms.repo.InsurancePlanRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsurancePlanService {

    @Autowired
    InsurancePlanRepo repo;


    public void addPlan(InsurancePlan plan){
        repo.save(plan);
    }

    public List<InsurancePlan> getPlans(){
        return repo.findAll();
    }
    public Optional<InsurancePlan> getPlan(Integer id){
        return repo.findById(id);
    }

    
    
}
