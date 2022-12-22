package com.slesha.planms.service;

import java.util.List;
import java.util.Optional;

import com.slesha.planms.dto.EnrollRequest;
import com.slesha.planms.entity.InsurancePlan;
import com.slesha.planms.entity.User;
import com.slesha.planms.entity.UserPlan;
import com.slesha.planms.repo.InsurancePlanRepo;
import com.slesha.planms.repo.UserPlanRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InsurancePlanService {

    @Autowired
    InsurancePlanRepo repo;

    @Autowired
    UserPlanRepo upRepo;

    @Autowired
    RestTemplate template;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


    public void addPlan(InsurancePlan plan){
        repo.save(plan);
    }

    @Cacheable(value = "plan",key = "'all'")
    public List<InsurancePlan> getPlans(){
        return repo.findAll();
    }
    public Optional<InsurancePlan> getPlan(Integer id){
        return repo.findById(id);
    }

    public Optional<User> getUser(String emailId){
        ResponseEntity<User> response=template.getForEntity("http://userms:8080/userms/"+emailId, User.class);
        if(response.getStatusCode()==HttpStatus.ACCEPTED){
            return Optional.of(response.getBody());
        }
        return Optional.ofNullable(null);
    }
    
    public List<UserPlan> enroll(EnrollRequest req){
            Optional<User> user=getUser(req.getEmailId());
            Optional<InsurancePlan> plan=getPlan(req.getPlanId());
            if(!user.isPresent() || !plan.isPresent()){
                throw new RuntimeException();
            }

            UserPlan up = new UserPlan();
            up.setUser(user.get());
            up.setAge(req.getAge());
            up.setGender(req.getGender());
            up.setSmoke(req.getSmoke());
            up.setPlan(plan.get());
            up.setType(req.getType());
            upRepo.save(up);
            upRepo.flush();
            kafkaTemplate.send("enroll",req.toString());
            return upRepo.findByEmailId(up.getUser().getEmailId());
            

    }

    
    
}
