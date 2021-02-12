package com.project.employeeManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.employeeManagementSystem.Repo.OfficeRepo;
import com.project.employeeManagementSystem.entity.Office;

@Service
public class OfficeService implements ServiceClass<Office> {

	
	@Autowired
	private OfficeRepo officeRepo;
	
	@Override
	@Transactional
	public List<Office> get() {
		
		List<Office> officeList = officeRepo.findAll();
		return officeList;
	}

	@Override
	@Transactional
	public Office findById(int id) {
		
		Optional<Office> result = officeRepo.findById(id);
		
		Office ofc= null;
		
		if(result.isPresent())
		{
			ofc = result.get();
		}
		else
		{
			// we did'nt find the office id
			throw new RuntimeException("Did not find office id " + id);
		}
		
		return ofc;
	}

	@Override
	@Transactional
	public void post(Office office) {
	
		officeRepo.save(office);
		
	}

	@Override
	@Transactional
	public Office update(Office office) {
		
		officeRepo.save(office);
		return office;
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		officeRepo.deleteById(id);
		
	}

}
