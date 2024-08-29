package com.example.jpaLab.model;

import jakarta.persistence.*;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeNumber;

    private String surname;
    private String firstName;
    private String address;
    private String phoneNumber;

}

