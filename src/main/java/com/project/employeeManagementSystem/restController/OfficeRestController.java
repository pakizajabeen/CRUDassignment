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

import com.project.employeeManagementSystem.Service.OfficeService;
import com.project.employeeManagementSystem.entity.Office;

@RestController
@RequestMapping("/office")
public class OfficeRestController {
	
	private OfficeService officeService;
	
	@Autowired
	public OfficeRestController(OfficeService officeService)
	{
		this.officeService = officeService;
	}

	
	@GetMapping("/offices")
    public List<Office> getAllOffices() {
    	
    	return officeService.get();
    	
    }
    
    @GetMapping("/office/{office_id}")
    public Office findById (@PathVariable int office_id) {
    	
    	Office ofc = officeService.findById(office_id);
    	
    	if(ofc==null)
    	{
    		throw new RuntimeException(" Office id not found: " + office_id);
    	}
    	return ofc;
	
    }
    

    @PostMapping("/office")
    public Office postOffice(@RequestBody Office office) {
        
    	office.setId(0);
    	officeService.post(office);

        return office;
    }
    
    @PutMapping("/office")
	public Office updateOffice(@RequestBody Office office)
	{
		officeService.update(office);
		return office;
	}
	
	@DeleteMapping("/office/{office_id}")
	public void deleteEmployee(@PathVariable int office_id)
	{
		Office ofc = officeService.findById(office_id);
		
		if (ofc == null)
		{
			throw new RuntimeException("Office id not found - " + office_id);
		}
		
		officeService.delete(office_id);
	}
	
}
