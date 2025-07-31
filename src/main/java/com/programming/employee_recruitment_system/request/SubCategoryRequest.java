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
public class SubCategoryRequest {

    @NotBlank(message = "Sub-category name is required")
    @Size(max = 100, message = "Sub-category name must be less than 100 characters")
    private String subCategoryName;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

}
