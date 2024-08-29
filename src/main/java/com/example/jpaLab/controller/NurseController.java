package com.example.jpaLab.controller;

import com.example.jpaLab.model.Nurse;
import com.example.jpaLab.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseService.createNurse(nurse);
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/surname/{surname}")
    public List<Nurse> getNursesBySurname(@PathVariable String surname) {
        return nurseService.getNursesBySurname(surname);
    }

    @DeleteMapping("/{id}")
    public void deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
    }
}

