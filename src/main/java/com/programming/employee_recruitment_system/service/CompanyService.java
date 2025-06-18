package com.programming.employee_recruitment_system.service;

import com.programming.employee_recruitment_system.dto.CompanyDTO;
import com.programming.employee_recruitment_system.request.CompanyRequest;
import com.programming.employee_recruitment_system.response.CompanyDeptResponse;
import com.programming.employee_recruitment_system.response.CompanyResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRequest companyRequest);

    List<CompanyResponse> getAllCompanies();

    CompanyResponse getCompanyById(Long companyId);

    String deleteCompany(Long companyId);

    CompanyDeptResponse getCompanyAndDeptDetails(Long companyId);
}
