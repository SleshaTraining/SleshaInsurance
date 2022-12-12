package com.slesha.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.slesha.userms.entity.User;
import com.slesha.userms.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public String signup(User user){
            repo.save(user);
            return "Signed up succesfully";
    }
    public List<User> getUsers(){
        return repo.findAll();
    }
}
