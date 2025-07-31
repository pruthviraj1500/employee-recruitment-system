package com.programming.employee_recruitment_system.repository;

import com.programming.employee_recruitment_system.model.Company;
import com.programming.employee_recruitment_system.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByDepartmentId(Long deptId);

    // Getting company and department details using join
    @Query("select s from SubCategory s left join fetch s.positions where s.id=?1")
    SubCategory getSubCategoryAndPositionDetails(Long subCatId);

}
