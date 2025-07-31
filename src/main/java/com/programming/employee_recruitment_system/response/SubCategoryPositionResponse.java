package com.programming.employee_recruitment_system.response;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubCategoryPositionResponse {

    private Long id;

    private String subCategoryName; // Java, React

    private Long departmentId;

    private List<PositionResponse> positions;

}
