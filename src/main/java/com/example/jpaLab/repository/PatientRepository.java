package com.example.jpaLab.repository;

import com.example.jpaLab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByPatientNumber(long patientNumber);

    List<Patient> findBySurname(String surname);

    List<Patient> findByDiagnosis(String diagnosis);
}
