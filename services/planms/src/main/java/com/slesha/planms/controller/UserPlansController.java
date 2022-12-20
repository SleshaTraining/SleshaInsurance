package com.slesha.planms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slesha.planms.entity.UserPlan;
import com.slesha.planms.service.UserPlansService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/planms/user")


public class UserPlansController {

    @Autowired
    private UserPlansService service;

    @GetMapping("/{emailId}")
    public ResponseEntity<List<UserPlan>> getUserPlans(@PathVariable String emailId){
        return new ResponseEntity<>(service.findAllByEmailId(emailId),HttpStatus.OK);
    }

    

}