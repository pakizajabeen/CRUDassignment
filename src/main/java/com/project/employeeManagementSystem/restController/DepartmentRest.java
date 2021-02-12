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

import com.project.employeeManagementSystem.Service.DepartmentService;
import com.project.employeeManagementSystem.entity.Department;

@RestController
@RequestMapping("/departmentapi")
public class DepartmentRest {
	

	private DepartmentService departmentService;
	
	// using Constructor injection
	@Autowired
	public  DepartmentRest(DepartmentService departmentService) {
		
		this.departmentService=departmentService;
	}
	
	@GetMapping("/departments")
    public List<Department> getAllDepartments() {
    	
    	return departmentService.get();
    	
    }
	
    @GetMapping("/departmentapi/{dept_id}")
    public Department findById (@PathVariable int dept_id) {
    	
    	Department dept = departmentService.findById(dept_id);
    	
    	if(dept==null)
    	{
    		throw new RuntimeException("Department not found: " + dept_id);
    	}
    	return dept;
	
    }
    

    @PostMapping("/departmentapi")
    public Department postDepartment(@RequestBody Department dept) {
        
    	dept.setId(0);
    	departmentService.post(dept);
   
        return dept;
    }
    
    @PutMapping("/departmentapi")
	public Department updateDepartment(@RequestBody Department dept)
	{
    	departmentService.update(dept);
		return dept;
	}
	
	@DeleteMapping("/departmentapi/{dept_id}")
	public void deleteDepartment(@PathVariable int dept_id)
	{
		Department dept = departmentService.findById(dept_id);
		
		if (dept == null)
		{
			throw new RuntimeException("Department not found - " + dept_id);
		}
		
		departmentService.delete(dept_id);

	}
    


}
