package com.programming.employee_recruitment_system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Java Developer
    private String job_description;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @OneToOne(mappedBy = "position", cascade = CascadeType.ALL)
    private RequirementCriteria criteria;

//  Bi-directional ----> Position <---> CandidateCV
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidateCV> candidateCVs = new ArrayList<>();

//  Bi-directional ----> Position <---> InterviewBatch
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InterviewBatch> interviewBatches = new ArrayList<>();
}
