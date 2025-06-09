package com.programming.employee_recruitment_system.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
    private Long id;

    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name must be less than 100 characters")
    private String company_name;

    @NotBlank(message = "Company address is required")
    @Size(max = 255, message = "Address must be less than 255 characters")
    private String company_address;

    @NotBlank(message = "Industry is required")
    @Size(max = 100, message = "Industry must be less than 100 characters")
    private String industry;
}
