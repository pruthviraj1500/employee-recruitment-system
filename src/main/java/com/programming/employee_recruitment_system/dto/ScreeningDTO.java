package com.programming.employee_recruitment_system.dto;


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
public class ScreeningDTO {
    private Long id;

    @NotNull(message = "Selection status must be specified")
    private boolean isSelected;

    @Size(max = 500, message = "Rejection reason must be less than 500 characters")
    private String rejectionReason;

    @NotNull(message = "Candidate CV ID is required")
    private Long candidateCvId;

    @NotNull(message = "Criteria ID is required")
    private Long criteriaId;
}
