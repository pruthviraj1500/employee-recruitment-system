package com.programming.employee_recruitment_system.service_impl;

import com.programming.employee_recruitment_system.custom_exception.ResourceNotFoundException;
import com.programming.employee_recruitment_system.model.Company;
import com.programming.employee_recruitment_system.model.Department;
import com.programming.employee_recruitment_system.model.SubCategory;
import com.programming.employee_recruitment_system.repository.DepartmentRepository;
import com.programming.employee_recruitment_system.repository.SubCategoryRepository;
import com.programming.employee_recruitment_system.request.DepartmentRequest;
import com.programming.employee_recruitment_system.request.SubCategoryRequest;
import com.programming.employee_recruitment_system.response.*;
import com.programming.employee_recruitment_system.service.SubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    private final DepartmentRepository departmentRepository;

    private final ModelMapper mapper;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    @Override
    public SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest) {
        Department department = departmentRepository.findById(subCategoryRequest.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid department Id.."));

        SubCategory subCategory = mapper.map(subCategoryRequest, SubCategory.class);
        subCategory.setDepartment(department);
        SubCategory persistSubCategory = subCategoryRepository.save(subCategory);

        SubCategoryResponse subCategoryResponse = SubCategoryResponse.builder()
                .id(persistSubCategory.getId())
                .subCategoryName(persistSubCategory.getSubCategoryName())
                .departmentId(persistSubCategory.getDepartment().getId())
                .build();

        return subCategoryResponse;
    }

    @Override
    public List<SubCategoryResponse> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream()
                .map(subCategory -> SubCategoryResponse.builder()
                        .id(subCategory.getId())
                        .subCategoryName(subCategory.getSubCategoryName())
                        .departmentId(subCategory.getDepartment() != null ? subCategory.getDepartment().getId() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryResponse getSubCategoryById(Long subCatId) {
        SubCategory subCategory = subCategoryRepository.findById(subCatId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid subCategory Id..."));

        return SubCategoryResponse.builder()
                .id(subCategory.getId())
                .subCategoryName(subCategory.getSubCategoryName())
                .departmentId(subCategory.getDepartment() != null ? subCategory.getDepartment().getId() : null)
                .build();
    }

    @Override
    public String deleteSubCategory(Long subCatId) {
        SubCategoryResponse subCategoryResponse = getSubCategoryById(subCatId);
        SubCategory subCategory = mapper.map(subCategoryResponse, SubCategory.class);
        subCategoryRepository.delete(subCategory);
        return "SubCategory records deleted for id "+subCatId;
    }

    @Override
    public List<SubCategoryResponse> getAllSubCategoriesFromDept(Long deptId) {
        List<SubCategory> subCategories = subCategoryRepository.findByDepartmentId(deptId);
        return subCategories.stream()
                .map(subCategory -> SubCategoryResponse.builder()
                        .id(subCategory.getId())
                        .subCategoryName(subCategory.getSubCategoryName())
                        .departmentId(subCategory.getDepartment() != null ? subCategory.getDepartment().getId() : null)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryPositionResponse getSubCategoryAndPositionDetails(Long subCatId) {
        SubCategory subCategory = subCategoryRepository.getSubCategoryAndPositionDetails(subCatId);

        List<PositionResponse> positionResponses = subCategory.getPositions().stream()
                .map(position -> PositionResponse.builder()
                        .id(position.getId())
                        .title(position.getTitle())
                        .jobDescription(position.getJobDescription())
                        .subCategoryId(subCategory.getId())
                        .build())
                .collect(Collectors.toList());

        return SubCategoryPositionResponse.builder()
                .id(subCategory.getId())
                .subCategoryName(subCategory.getSubCategoryName())
                .departmentId(subCategory.getDepartment() != null ? subCategory.getDepartment().getId() : null)
                .positions(positionResponses)
                .build();

    }
}
