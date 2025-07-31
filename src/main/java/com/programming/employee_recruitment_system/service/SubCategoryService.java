package com.programming.employee_recruitment_system.service;

import com.programming.employee_recruitment_system.request.SubCategoryRequest;
import com.programming.employee_recruitment_system.response.SubCategoryPositionResponse;
import com.programming.employee_recruitment_system.response.SubCategoryResponse;

import java.util.List;

public interface SubCategoryService {

    SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest);

    List<SubCategoryResponse> getAllSubCategories();

    SubCategoryResponse getSubCategoryById(Long subCatId);

    String deleteSubCategory(Long subCatId);

    List<SubCategoryResponse> getAllSubCategoriesFromDept(Long deptId);

    SubCategoryPositionResponse getSubCategoryAndPositionDetails(Long subCatId);
}
