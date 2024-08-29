package com.example.jpaLab.repository;

import com.example.jpaLab.model.Department;
import com.example.jpaLab.model.Nurse;
import com.example.jpaLab.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {

    List<Ward> findByDepartment(Department department);

    List<Ward> findBySupervisor(Nurse supervisor);

    List<Ward> findByNumberOfBeds(Integer numberOfBeds);
}
