package com.project.employeeManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagementSystem.entity.Office;

@Repository
public interface OfficeRepo extends JpaRepository<Office, Integer> {

}
