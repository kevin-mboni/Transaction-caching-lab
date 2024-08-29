package com.example.jpaLab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name ="Doctor")
public class Doctor extends Employee {
    private String speciality;
}