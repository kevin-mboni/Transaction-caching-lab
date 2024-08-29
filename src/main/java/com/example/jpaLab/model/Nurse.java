package com.example.jpaLab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Nurse extends Employee {
        private String rotation;
        private Double salary;

        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;
}
