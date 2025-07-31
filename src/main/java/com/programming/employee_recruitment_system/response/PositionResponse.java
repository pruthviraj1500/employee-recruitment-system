package com.programming.employee_recruitment_system.response;

import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PositionResponse {

    private Long id;

    private String title; // Java Developer

    private String jobDescription;

    private Long subCategoryId;

}
