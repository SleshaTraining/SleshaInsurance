package com.slesha.planms.controller;

import java.util.List;
import java.util.Optional;

import com.slesha.planms.entity.InsurancePlan;
import com.slesha.planms.service.InsurancePlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/planms")
public class InsurancePlanController {
    
    @Autowired
    InsurancePlanService service;

    @PostMapping()
    public ResponseEntity<String> addPlan(@RequestBody InsurancePlan plan){
        try{
            service.addPlan(plan);
            return new ResponseEntity<>("Plan Added",HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<InsurancePlan>> getPlans(){
        return new ResponseEntity<>(service.getPlans(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InsurancePlan> getPlan(@PathVariable Integer id){
        Optional<InsurancePlan> data=service.getPlan(id);
        if(data.isPresent()){
            return new ResponseEntity<>(data.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     
    }
    @PostMapping("/enroll")
    public void enrollInPlan(){
            
    }
    
}
