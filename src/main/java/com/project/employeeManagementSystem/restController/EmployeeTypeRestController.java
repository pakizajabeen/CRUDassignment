package com.project.employeeManagementSystem.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeeManagementSystem.Service.EmployeeTypeService;
import com.project.employeeManagementSystem.entity.EmployeeType;

@RestController
@RequestMapping("/type")
public class EmployeeTypeRestController {
	
	
	private EmployeeTypeService employeeTypeService;
	
	 // using Constructor injection
	@Autowired
	public EmployeeTypeRestController (EmployeeTypeService employeeTypeService)
	{
		this.employeeTypeService  = employeeTypeService;
	}
	
	 @GetMapping("/employeetype")
	    public List<EmployeeType> getAllEmployeesType() {
	    	
	    	return employeeTypeService.get();
	    	
	    }
	    
	    @GetMapping("/type/{type_id}")
	    public EmployeeType findById (@PathVariable int type_id) {
	    	
	    	EmployeeType type = employeeTypeService.findById(type_id);
	    	
	    	if(type==null)
	    	{
	    		throw new RuntimeException("Type id not found: " + type_id);
	    	}
	    	return type;
		
	    }
	    

	    @PostMapping("/type")
	    public void postEmployeeType(@RequestBody EmployeeType type) {
	        
	    	type.setId(0);
	    	employeeTypeService.post(type);

	      
	    }
	    
	    @PutMapping("/type")
		public EmployeeType updateEmployeeType(@RequestBody EmployeeType type)
		{
			employeeTypeService.update(type);
			return type;
		}
		
		@DeleteMapping("/type/{type_id}")
		public void deleteEmployeeType(@PathVariable int type_id)
		{
			EmployeeType type = employeeTypeService.findById(type_id);
	    	
	    	if(type==null)
	    	{
	    		throw new RuntimeException("Type id not found: " + type_id);
	    	}
			
			employeeTypeService.delete(type_id);
		
		}
	   
	}
