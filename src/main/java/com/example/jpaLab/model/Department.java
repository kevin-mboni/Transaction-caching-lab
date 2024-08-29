package com.example.jpaLab.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departmentCode;
    private String departmentName;
    private String building;

    @OneToOne
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private List<Ward> wards;

    @OneToMany(mappedBy = "department")
    private List<Nurse> nurses;

    // Getters and Setters
}
