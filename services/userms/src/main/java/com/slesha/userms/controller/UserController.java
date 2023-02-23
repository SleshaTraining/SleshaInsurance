package com.slesha.userms.controller;

import java.util.List;
import java.util.Optional;

import com.slesha.userms.dto.LoginRequest;
import com.slesha.userms.entity.User;
import com.slesha.userms.service.UserService;

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
@RequestMapping("/userms")
@CrossOrigin(origins = "*")
public class UserController{

    @Autowired
    UserService serv;
    
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
      try{
       

        String resp=serv.signup(user);
        return new ResponseEntity<String>(resp, HttpStatus.CREATED);
      }
      catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers(){
        try{
          System.out.println(serv.getUsers());
            return new ResponseEntity<>(serv.getUsers(),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<User> getUser(@PathVariable String emailId){
      Optional<User> user=serv.getUser(emailId);
      if(!user.isPresent()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(user.get(),HttpStatus.ACCEPTED);
   }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest req){
       Optional<User> user=serv.login(req);
       if(!user.isPresent()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}