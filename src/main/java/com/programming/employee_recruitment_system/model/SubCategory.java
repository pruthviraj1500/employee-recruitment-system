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
@Table(name = "sub_category")
public class SubCategory extends CommonEntityFields {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "sub_category_name")
    private String subCategoryName; // Java, React

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

//  Bi-directional ----> SubCategory <---> Position
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Position> positions = new ArrayList<>();

}
