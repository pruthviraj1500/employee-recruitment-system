package com.programming.employee_recruitment_system.dto;


import com.programming.employee_recruitment_system.custom_annotation.NullOrNotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;

//    @NotBlank(message = "Full name is required")
//    @Size(max = 50, message = "Full name must be less than 100 characters")

    @NullOrNotBlank(min = 1, max = 50, isMandatory = "yes", message = "Full Name is required and must be between {min} and {max} characters.")
    private String fullName;

//    @NotBlank(message = "Email is required")
//    @Email(message = "Email must be valid")

    @NullOrNotBlank(min = 5, max = 100, isMandatory = "yes", isEmail = "yes", message = "Valid email address is required and must be between {min} and {max} characters long.")
    private String email;

//    @NotBlank(message = "Role is required")
//    @Size(max = 30, message = "Role must be less than 50 characters")

    @NullOrNotBlank(min = 1, max = 30, isMandatory = "yes", message = "Role is required and must be between {min} and {max} characters.")
    private String role;

//    @NotNull(message = "Company ID is required")
    private Long companyId;

//    @NotNull(message = "Sub-category ID is required")
    private Long subCategoryId;
//    private Set<Long> interviewBatchIds;
}
