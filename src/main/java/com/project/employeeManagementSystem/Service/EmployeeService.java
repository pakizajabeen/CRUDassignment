package com.project.employeeManagementSystem.Service;

import java.util.List; 
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.employeeManagementSystem.Repo.EmployeeRepo;
import com.project.employeeManagementSystem.entity.Employee;

@Service
public class EmployeeService implements ServiceClass<Employee> {
	
	@Autowired
    private EmployeeRepo employeeRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> get() {
		
		List<Employee> employeeList = employeeRepo.findAll();
		return employeeList;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepo.findById(id);
		
		Employee emp = null;
		
		if(result.isPresent())
		{
			emp = result.get();
		}
		else
		{
			// we did'nt find the employee
			throw new RuntimeException("Did not find employee id " + id);
		}
		
		return emp;
	}

	@Override
	@Transactional
	public void post(@Valid Employee employee) {
		
		employeeRepo.save(employee);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		employeeRepo.deleteById(id);

	}
	
	// Selecting data from 3 tables using LEFT JOIN
	
	// return a list of employees who has a department and also return their posts
	
	public List<Employee> usingJoins()
	{
		TypedQuery<Employee> query = entityManager.createQuery(
	    		  
	          "SELECT e.name, e.email, e.salary, d.name, em.emp_type  FROM Employee e left join Department d on e.id = d.id " + 
	      
	        		  	"left join EmployeeType em on em.id=e.id ", Employee.class);
	   
		List<Employee> resultList = query.getResultList();
		
		return resultList;
	}
	
	
	// Selecting data from 2 tables 
	
	// get the list of employees who has alloted a department
	
	public List<Employee> usingJoin()
	{
		
		TypedQuery<Employee> query = entityManager.createQuery(
				"SELECT e.name, e.email, e.salary, e.address, d.name FROM Employee e left join Department d on e.id = d.id", Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		return resultList;
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
