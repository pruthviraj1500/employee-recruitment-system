package com.programming.employee_recruitment_system.repository;

import com.programming.employee_recruitment_system.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    // Getting company and department details using join
    @Query("select c from Company c left join fetch c.departments where c.id=?1")
    Company getCompanyAndDeptDetails(Long companyId);

}
