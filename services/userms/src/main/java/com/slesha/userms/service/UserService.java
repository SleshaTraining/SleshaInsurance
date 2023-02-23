package com.slesha.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.slesha.userms.dto.LoginRequest;
import com.slesha.userms.entity.User;
import com.slesha.userms.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    @Autowired
    KafkaTemplate<String,String> template;

    public String signup(User user){
       String m= "+1" + user.getPhone();
          user.setphone(m);
            repo.save(user);
            return "Signed up succesfully";
    }
    public List<User> getUsers(){
        
        return repo
                .findAll()
                .stream()
                .map(
                    x->{x.setPassword("");
                        return x;})
                .collect(Collectors.toList());
    }

    public Optional<User> login(LoginRequest req){
        template.send("login",req.getEmailId());
       return repo.findByEmailIdAndPassword(req.getEmailId(), req.getPassword());
    }
    public Optional<User> getUser(String emailId){
        return repo.findByEmailId(emailId);
     }


    
}
