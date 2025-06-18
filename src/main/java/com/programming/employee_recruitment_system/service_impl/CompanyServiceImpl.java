package com.programming.employee_recruitment_system.service_impl;

import com.programming.employee_recruitment_system.custom_exception.ResourceNotFoundException;
import com.programming.employee_recruitment_system.dto.CompanyDTO;
import com.programming.employee_recruitment_system.model.Company;
import com.programming.employee_recruitment_system.repository.CompanyRepository;
import com.programming.employee_recruitment_system.request.CompanyRequest;
import com.programming.employee_recruitment_system.response.CompanyDeptResponse;
import com.programming.employee_recruitment_system.response.CompanyResponse;
import com.programming.employee_recruitment_system.response.DepartmentResponse;
import com.programming.employee_recruitment_system.service.CompanyService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final ModelMapper mapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = mapper.map(companyRequest, Company.class);
        Company persistCompany = companyRepository.save(company);
        return mapper.map(persistCompany, CompanyResponse.class);
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> mapper.map(company, CompanyResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId)
                         .orElseThrow(() -> new ResourceNotFoundException("Invalid Dept id"));
        return mapper.map(company, CompanyResponse.class);
    }

    @Override
    public String deleteCompany(Long companyId) {
        CompanyResponse companyResponse = getCompanyById(companyId);
        Company company = mapper.map(companyResponse, Company.class);
        companyRepository.delete(company);
        return "Company records deleted for id "+companyId;
    }

    @Override
    public CompanyDeptResponse getCompanyAndDeptDetails(Long companyId) {
        Company company = companyRepository.getCompanyAndDeptDetails(companyId);

        List<DepartmentResponse> departmentResponses = company.getDepartments().stream()
                .map(dept -> DepartmentResponse.builder()
                        .id(dept.getId())
                        .departmentName(dept.getDepartmentName())
                        .companyId(company.getId())
                        .build())
                .collect(Collectors.toList());

        return CompanyDeptResponse.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .companyAddress(company.getCompanyAddress())
                .industry(company.getIndustry())
                .departments(departmentResponses)
                .build();

//        return mapper.map(company, CompanyDeptResponse.class);  // In response getting companyId null
    }
}
