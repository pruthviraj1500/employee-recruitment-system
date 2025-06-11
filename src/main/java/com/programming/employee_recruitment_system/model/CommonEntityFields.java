package com.programming.employee_recruitment_system.model;

import jakarta.persistence.*;

@MappedSuperclass
public class CommonEntityFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
