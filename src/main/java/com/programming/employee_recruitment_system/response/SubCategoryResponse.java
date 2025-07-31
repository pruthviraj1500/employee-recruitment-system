package com.programming.employee_recruitment_system.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryResponse {

    private Long id;

    private String subCategoryName; // Java, React

    private Long departmentId;
}
