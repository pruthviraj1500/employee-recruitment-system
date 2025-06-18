package com.programming.employee_recruitment_system.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse{

    private Long id;

    private String companyName;

    private String companyAddress;

    private String industry;
}
