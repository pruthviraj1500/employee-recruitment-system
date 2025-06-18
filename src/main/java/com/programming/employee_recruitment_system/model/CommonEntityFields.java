package com.programming.employee_recruitment_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class CommonEntityFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
