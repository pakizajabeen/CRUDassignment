package com.project.employeeManagementSystem.Service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.employeeManagementSystem.Repo.EmployeeTypeRepo;
import com.project.employeeManagementSystem.entity.EmployeeType;

@Service
public class EmployeeTypeService implements ServiceClass<EmployeeType> {

	@Autowired
    private EmployeeTypeRepo employeeTypeRepo;
	
	@Override
	public List<EmployeeType> get() {
		
		List<EmployeeType> employeeTypeList = employeeTypeRepo.findAll();
		return employeeTypeList;
	}

	@Override
	@Transactional
	public EmployeeType findById(int id) {
		
		Optional<EmployeeType> result = employeeTypeRepo.findById(id);
		
		EmployeeType type = null;
		
		if(result.isPresent())
		{
			type = result.get();
		}
		else
		{
			// we did'nt find the employee
			throw new RuntimeException("Did not find employee type" + id);
		}
		
		return type;
	}


	@Override
	@Transactional
	public void post(EmployeeType type) {
		
		employeeTypeRepo.save(type);
		
	}

	@Override
	@Transactional
	public EmployeeType update(EmployeeType type) {
		
		employeeTypeRepo.save(type);
		return type;
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		employeeTypeRepo.deleteById(id);
		
	}

}
