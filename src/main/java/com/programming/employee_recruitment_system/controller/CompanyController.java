package com.programming.employee_recruitment_system.controller;


import com.programming.employee_recruitment_system.dto.CompanyDTO;
import com.programming.employee_recruitment_system.request.CompanyRequest;
import com.programming.employee_recruitment_system.response.CompanyDeptResponse;
import com.programming.employee_recruitment_system.response.CompanyResponse;
import com.programming.employee_recruitment_system.service.CompanyService;
import com.programming.employee_recruitment_system.service_impl.CompanyServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> addCompany(@RequestBody @Valid CompanyRequest companyRequest){
        System.out.println("Inside controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(companyRequest));
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<List<CompanyResponse>> getAllCompanies(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompanies());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long companyId){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(companyId));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteCompany(companyId));
    }

    @GetMapping("/{companyId}/dept")
    public ResponseEntity<CompanyDeptResponse> getCompanyAndDeptDetails(@PathVariable Long companyId){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyAndDeptDetails(companyId));
    }

}
