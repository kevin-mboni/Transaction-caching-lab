package com.example.jpaLab.service;


import com.example.jpaLab.model.Department;
import com.example.jpaLab.model.Ward;
import com.example.jpaLab.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class WardService {

        @Autowired
        private WardRepository wardRepository;

        public Ward createWard(Ward ward) {
            return wardRepository.save(ward);
        }

        public List<Ward> getAllWards() {
            return wardRepository.findAll();
        }

        public List<Ward> getWardsByDepartment(Department department) {
            return wardRepository.findByDepartment(department);
        }

        public void deleteWard(Integer id) {
            wardRepository.deleteById(id);
        }
    }


