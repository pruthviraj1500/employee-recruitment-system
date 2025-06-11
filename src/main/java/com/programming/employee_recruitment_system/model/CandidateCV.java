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
@Table(name = "candidate_resume")
public class CandidateCV extends CommonEntityFields {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "resume_link", unique = true)
    private String resumeLink;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
