package com.programming.employee_recruitment_system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequirementCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minExperience; // year of exp.
    private String requiredSkills; // Java, Spring Boot, DevOps

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
