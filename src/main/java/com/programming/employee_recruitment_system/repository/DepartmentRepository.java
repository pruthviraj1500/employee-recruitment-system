package com.programming.employee_recruitment_system.repository;

import com.programming.employee_recruitment_system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    // select d from Department d where d.comp.id=:id
    List<Department> findByCompanyId(Long companyId);
}
