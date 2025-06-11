package com.programming.employee_recruitment_system.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requirement_criteria")
public class RequirementCriteria extends CommonEntityFields {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "min_experience")
    private int minExperience; // year of exp.

    @Column(name = "requirement_skills")
    private String requiredSkills; // Java, Spring Boot, DevOps

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
