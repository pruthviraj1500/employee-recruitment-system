package com.programming.employee_recruitment_system.dto;


import jakarta.validation.constraints.Min;
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
public class RequirementCriteriaDTO {
    private Long id;

    @Min(value = 0, message = "Minimum experience must be 0 or more")
    private int minExperience;

    @NotBlank(message = "Required skills must not be empty")
    @Size(max = 500, message = "Required skills must be less than 500 characters")
    private String requiredSkills;

    @NotNull(message = "Position ID is required")
    private Long positionId;
}
