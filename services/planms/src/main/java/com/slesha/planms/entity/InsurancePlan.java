package com.slesha.planms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor()
public class InsurancePlan implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planId;
    private String planName;
    private String planArea;
    private Integer averagePremium;
    private Integer maximumCoverage;
    
}
