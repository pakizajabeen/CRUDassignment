package com.project.employeeManagementSystem.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {


    
}
