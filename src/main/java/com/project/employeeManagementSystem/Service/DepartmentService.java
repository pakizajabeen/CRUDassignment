package com.project.employeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.employeeManagementSystem.Repo.DepartmentRepo;
import com.project.employeeManagementSystem.entity.Department;

@Service
public class DepartmentService implements ServiceClass<Department> {
	
		@Autowired
	    private DepartmentRepo departmentRepo;

	@Override
	@Transactional
	public List<Department> get() {
		
		List<Department> departmentList = departmentRepo.findAll();
		return departmentList;
	}

	@Override
	@Transactional
	public Department findById(int id) {
Optional<Department> result = departmentRepo.findById(id);
		
		Department dept = null;
		
		if(result.isPresent())
		{
			dept = result.get();
		}
		else
		{
		
			throw new RuntimeException("Did not find employee id " + id);
		}
		
		return dept;
	}

	@Override
	@Transactional
	public void post(Department dept) {
	
		departmentRepo.save(dept);
		
	}

	@Override
	@Transactional
	public Department update(Department dept) {
		departmentRepo.save(dept);
		return dept;
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		departmentRepo.deleteById(id);
	}
	
	

}
