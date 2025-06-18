package com.programming.employee_recruitment_system.service_impl;

import com.programming.employee_recruitment_system.custom_exception.ResourceNotFoundException;
import com.programming.employee_recruitment_system.model.Company;
import com.programming.employee_recruitment_system.model.Department;
import com.programming.employee_recruitment_system.repository.CompanyRepository;
import com.programming.employee_recruitment_system.repository.DepartmentRepository;
import com.programming.employee_recruitment_system.request.DepartmentRequest;
import com.programming.employee_recruitment_system.response.CompanyResponse;
import com.programming.employee_recruitment_system.response.DepartmentResponse;
import com.programming.employee_recruitment_system.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final CompanyRepository companyRepository;

    private final ModelMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, CompanyRepository companyRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public DepartmentResponse addNewDepartment(DepartmentRequest departmentRequest) {
        Company company = companyRepository.findById(departmentRequest.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid company Id.."));

        Department department = mapper.map(departmentRequest, Department.class);
        department.setCompany(company);
        Department persistDept = departmentRepository.save(department);

        DepartmentResponse departmentResponse = DepartmentResponse.builder()
                .id(persistDept.getId())
                .departmentName(persistDept.getDepartmentName())
                .companyId(persistDept.getCompany().getId())
                .build();
        return departmentResponse;
//      return mapper.map(persistDept, DepartmentResponse.class);  // In response getting companyId null
    }

    @Override
    public List<DepartmentResponse> getAllDepartmentDetails() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().
                map(department -> DepartmentResponse.builder()
                        .id(department.getId())
                        .departmentName(department.getDepartmentName())
                        .companyId(department.getCompany() != null ? department.getCompany().getId() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Department Id..."));

        return DepartmentResponse.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .companyId(department.getCompany() != null ? department.getCompany().getId() : null)
                .build();
//        return mapper.map(department, DepartmentResponse.class);
    }

    @Override
    public List<DepartmentResponse> getAllDeptFromCompany(Long companyId) {
        List<Department> deptList = departmentRepository.findByCompanyId(companyId);
        return deptList.stream()
                .map(department -> DepartmentResponse.builder()
                        .id(department.getId())
                        .departmentName(department.getDepartmentName())
                        .companyId(department.getCompany() != null ? department.getCompany().getId() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String deleteDepartment(Long deptId) {
        DepartmentResponse departmentResponse = getDepartmentById(deptId);
        Department department = mapper.map(departmentResponse, Department.class);
        departmentRepository.delete(department);
        return "Department records deleted for id "+deptId;
    }
}
