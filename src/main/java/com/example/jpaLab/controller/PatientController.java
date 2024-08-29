package com.example.jpaLab.controller;

import com.example.jpaLab.model.Patient;
import com.example.jpaLab.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }
    @GetMapping("/{id}")
    public List<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientByPatientNumber(id);
    }

    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @GetMapping("/patients/{patientNumber}")
    public Patient getPatient(@PathVariable Long patientNumber) {
        return patientService.getPatientById(patientNumber);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @PutMapping("/{patientNumber}")
    public ResponseEntity<Patient> updatePatientInformation(
            @PathVariable Long patientNumber,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            @RequestParam String diagnosis) {

        Patient updatedPatient = patientService.updatePatientInformation(
                patientNumber, name, surname, address, phoneNumber, diagnosis);

        return ResponseEntity.ok(updatedPatient);
    }

}
