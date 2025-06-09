package com.programming.employee_recruitment_system.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterviewBatchDTO {
    private Long id;

    @NotNull(message = "Interview date is required")
    @FutureOrPresent(message = "Interview date must be today or in the future")
    private LocalDate date;

    @NotBlank(message = "Time slot is required")
    private String timeSlot;

    @NotNull(message = "Position ID is required")
    private Long positionId;

    @NotNull(message = "Candidate CV ID is required")
    private Long candidateCvId;

    @NotEmpty(message = "At least one interviewer ID must be provided")
    private Set<Long> interviewerIds;
}
