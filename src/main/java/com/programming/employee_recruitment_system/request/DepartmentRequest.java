package com.programming.employee_recruitment_system.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequest {
//    private Long id;

    @NotBlank(message = "Department name is required")
    @Size(max = 100, message = "Department name must be less than 100 characters")
    private String departmentName;

    @NotNull(message = "Company ID is required")
    private Long companyId;
}
