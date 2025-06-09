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
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isSelected;
    private String rejectionReason;

    @ManyToOne
    @JoinColumn(name = "candidate_cv_id")
    private CandidateCV candidateCV;

    @ManyToOne
    @JoinColumn(name = "criteria_id")
    private RequirementCriteria criteria;
}
