package com.project.employeeManagementSystem.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeeManagementSystem.Service.EmployeeService;
import com.project.employeeManagementSystem.entity.Employee;

@RestController
@RequestMapping("/employeeapi")
public class EmployeeRestController {
	
	
    private EmployeeService employeeService;

    // using Constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
    	
    	return employeeService.get();
    	
    }
    
    @GetMapping("/employeeapi/{employee_id}")
    public Employee findById (@PathVariable int employee_id) {
    	
    	Employee emp = employeeService.findById(employee_id);
    	
    	if(emp==null)
    	{
    		throw new RuntimeException("Employee id not found: " + employee_id);
    	}
    	return emp;
	
    }
    

    @PostMapping("/employeeapi")
    public Employee postEmployee(@Valid @RequestBody Employee employee) {
        
    	employee.setId(0);
    	employeeService.post(employee);

        return employee;
    }
    
    @PutMapping("/employeeapi")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		employeeService.update(employee);
		return employee;
	}
	
	@DeleteMapping("/employeeapi/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId)
	{
		Employee emp = employeeService.findById(employeeId);
		
		if (emp == null)
		{
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.delete(employeeId);
	}
	
	// USING JOINS
	
	// Selecting data from 3 tables using LEFT JOIN
	
	// return a list of employees who has a department and also return their posts
	
	@GetMapping("/employeesusingjoin")
	public List<Employee> getEmployeesUsingJoin() {
		
		return employeeService.usingJoins();
		
	}
	
	// Get the list of employees who has alloted a department
	
	@GetMapping("/employeesusingleftjoin")
	public List<Employee> getEmployeesUsingleftJoins() {
		
		return employeeService.usingJoin();
	}
    

}
