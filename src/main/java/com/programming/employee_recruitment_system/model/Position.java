package com.programming.employee_recruitment_system.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "position")
public class Position extends CommonEntityFields {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "title")
    private String title; // Java Developer

    @Column(name = "job_description")
    private String jobDescription;

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
