package com.example.jpaLab.service;

import com.example.jpaLab.model.Patient;
import com.example.jpaLab.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);


    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getPatientByPatientNumber(Long patientNumber) {
        return patientRepository.findByPatientNumber(patientNumber);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Cacheable(value = "patients", key = "#patientNumber")
    public Patient getPatientById(Long patientNumber) {
        logger.info("Fetching patient with ID {} from database", patientNumber);
        return patientRepository.findById(patientNumber)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

    }

    @Transactional
    @CacheEvict(value = "patients", key = "#patientNumber")
    public Patient updatePatientInformation(Long patientNumber, String name, String surname, String address, String phoneNumber, String diagnosis) {
        Patient patient = patientRepository.findById(patientNumber)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        patient.setName(name);
        patient.setSurname(surname);
        patient.setAddress(address);
        patient.setPhoneNumber(phoneNumber);
        patient.setDiagnosis(diagnosis);

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
