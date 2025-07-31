package com.programming.employee_recruitment_system.controller;

import com.programming.employee_recruitment_system.request.SubCategoryRequest;
import com.programming.employee_recruitment_system.response.CompanyDeptResponse;
import com.programming.employee_recruitment_system.response.SubCategoryPositionResponse;
import com.programming.employee_recruitment_system.response.SubCategoryResponse;
import com.programming.employee_recruitment_system.service.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subCategory")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("/addSubCategory")
    public ResponseEntity<SubCategoryResponse> addSubCategoryToExistingDept
                                              (@RequestBody @Valid SubCategoryRequest subCategoryRequest){
        System.out.println("Inside controller...");
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.createSubCategory(subCategoryRequest));
    }

    @GetMapping("/getAllSubCategories")
    public ResponseEntity<List<SubCategoryResponse>> getAllSubCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getAllSubCategories());
    }

    @GetMapping("/{subCatId}")
    public ResponseEntity<SubCategoryResponse> getSubCategoryById(@PathVariable Long subCatId){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getSubCategoryById(subCatId));
    }

    @DeleteMapping("/{subCatId}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable Long subCatId){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.deleteSubCategory(subCatId));
    }

    @GetMapping("/getSubCategoryByDept/{deptId}")
    public ResponseEntity<List<SubCategoryResponse>> getAllSubCategoriesFromDept(@PathVariable Long deptId){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getAllSubCategoriesFromDept(deptId));
    }

    @GetMapping("/{subCatId}/position")
    public ResponseEntity<SubCategoryPositionResponse> getSubCategoryAndPositionDetails(@PathVariable Long subCatId){
        return ResponseEntity.status(HttpStatus.OK).body(subCategoryService.getSubCategoryAndPositionDetails(subCatId));
    }

}
