package com.programming.employee_recruitment_system.controller;


import com.programming.employee_recruitment_system.request.DepartmentRequest;
import com.programming.employee_recruitment_system.response.DepartmentResponse;
import com.programming.employee_recruitment_system.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentResponse> addDeptToExistingComp(@RequestBody @Valid DepartmentRequest departmentRequest){
        System.out.println("inside controller..");
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addNewDepartment(departmentRequest));
    }

    @GetMapping("/getAllDept")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartment(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartmentDetails());
    }

    @GetMapping("/{deptId}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long deptId){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentById(deptId));
    }

    @GetMapping("/getDeptByCompany/{companyId}")
    public ResponseEntity<List<DepartmentResponse>> getDeptByCompany(@PathVariable Long companyId){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDeptFromCompany(companyId));
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long deptId){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.deleteDepartment(deptId));
    }

}
