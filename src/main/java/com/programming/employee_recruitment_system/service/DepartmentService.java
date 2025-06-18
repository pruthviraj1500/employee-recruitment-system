package com.programming.employee_recruitment_system.service;

import com.programming.employee_recruitment_system.request.DepartmentRequest;
import com.programming.employee_recruitment_system.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

     DepartmentResponse addNewDepartment(DepartmentRequest departmentRequest);

     List<DepartmentResponse> getAllDepartmentDetails();

     DepartmentResponse getDepartmentById(Long deptId);

     List<DepartmentResponse> getAllDeptFromCompany(Long companyId);

     String deleteDepartment(Long deptId);
}
