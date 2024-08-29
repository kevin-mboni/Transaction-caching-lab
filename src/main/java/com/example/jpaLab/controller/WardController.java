package com.example.jpaLab.controller;

import com.example.jpaLab.model.Department;
import com.example.jpaLab.model.Ward;
import com.example.jpaLab.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wards")
public class WardController {

    @Autowired
    private WardService wardService;

    @PostMapping
    public Ward createWard(@RequestBody Ward ward) {
        return wardService.createWard(ward);
    }

    @GetMapping
    public List<Ward> getAllWards() {
        return wardService.getAllWards();
    }

    @GetMapping("/department")
    public List<Ward> getWardsByDepartment(@RequestBody Department department) {
        return wardService.getWardsByDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteWard(@PathVariable Integer id) {
        wardService.deleteWard(id);
    }
}
