package com.project.employeeManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.entity.EmployeeType;

@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType,Integer> {

}
