package com.programming.employee_recruitment_system.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRequest {
    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name must be less than 100 characters")
    private String companyName;

    @NotBlank(message = "Company address is required")
    @Size(max = 255, message = "Address must be less than 255 characters")
    private String companyAddress;

    @NotBlank(message = "Industry is required")
    @Size(max = 100, message = "Industry must be less than 100 characters")
    private String industry;
}
