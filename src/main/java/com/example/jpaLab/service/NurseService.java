package com.example.jpaLab.service;

import com.example.jpaLab.model.Nurse;
import com.example.jpaLab.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {
    @Autowired
    private NurseRepository nurseRepository;

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public List<Nurse> getNursesBySurname(String surname) {
        return nurseRepository.findBySurname(surname);
    }

    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
