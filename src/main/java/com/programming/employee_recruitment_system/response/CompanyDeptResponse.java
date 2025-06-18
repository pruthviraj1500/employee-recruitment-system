package com.programming.employee_recruitment_system.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyDeptResponse {
    private Long id;

    private String companyName;

    private String companyAddress;

    private String industry;

    private List<DepartmentResponse> departments;
}
