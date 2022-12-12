package com.slesha.userms.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor()
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(unique = true)
    private String emailId;
    private String userName;
    private String zip;
    private LocalDate dob;
    @Column(unique = true)
    private String phone;
    private String password;

    
}