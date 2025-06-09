package com.programming.employee_recruitment_system.dto;


import jakarta.validation.constraints.Email;
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
public class CandidateCVDTO {
    private Long id;

    @NotBlank(message = "Candidate name is required")
    @Size(max = 100, message = "Candidate name must be less than 100 characters")
    private String candidateName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Resume link is required")
    @Size(max = 255, message = "Resume link must be less than 255 characters")
    private String resumeLink;

    @NotNull(message = "Position ID is required")
    private Long positionId;
}
