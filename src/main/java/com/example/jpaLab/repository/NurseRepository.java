package com.example.jpaLab.repository;

import com.example.jpaLab.model.Department;
import com.example.jpaLab.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {

    // Custom query method to find nurses by surname
    List<Nurse> findBySurname(String surname);

    List<Nurse> findByDepartment(Department department);
    List<Nurse> findByRotation(String rotation);
}
