package com.programming.employee_recruitment_system.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryDTO {
    private Long id;

    @NotBlank(message = "Sub-category name is required")
    @Size(max = 100, message = "Sub-category name must be less than 100 characters")
    private String name;

    @NotNull(message = "Department ID is required")
    private Long departmentId;
}
