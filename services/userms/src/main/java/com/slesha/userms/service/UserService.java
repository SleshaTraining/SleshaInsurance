package com.slesha.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

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


    @PostConstruct
    public void init(){
        if(repo.findAll().size()<100){
            char[] alph="abcdefghijklmnopqrstuvwxyz".toCharArray();
            List<User> users = new ArrayList<>();
            for(int i=0;i<100;i++){
                String name="";
                for(int j=0;j<5;j++){
                        name+=alph[(int)(Math.random()*26)];
                }
                String mail=name+"@gmail.com";
                String pwd= name+"@123";
                User user= new User();
                user.setEmailId(mail);
                user.setPassword(pwd);
                user.setUserName(name);
                users.add(user);
            }
            
            repo.saveAll(users);
            
        }
        
    }


    
}
