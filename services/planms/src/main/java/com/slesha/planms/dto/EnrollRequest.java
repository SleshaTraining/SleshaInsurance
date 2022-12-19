package com.slesha.planms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnrollRequest {

    private String emailId;
    private Integer planId;
    private Integer type;
    private Integer age;
    private String gender;
    private Boolean smoke;
    
}
