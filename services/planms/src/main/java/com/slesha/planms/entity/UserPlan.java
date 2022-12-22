package com.slesha.planms.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserPlan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userPlanId;
    @ManyToOne
    private User user;
    @ManyToOne
    private InsurancePlan plan;

    private Integer type;
    private String gender;
    private Integer age;
    private Boolean smoke;

    
}
