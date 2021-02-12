package com.project.employeeManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name  = "emp_type")
public class EmployeeType {
	
	@Column(name ="id")
	private int id;
	
	
	@Column(name ="name")
	private String emp_type;
	
	@Column(name ="description")
	private String description;
	
	
	@OneToMany(targetEntity = Employee.class, mappedBy = "id", fetch = FetchType.LAZY)
	private Employee employee;

	public EmployeeType()
	{
		
	}

	public EmployeeType(String emp_type, String description, Employee employee) {
		super();
		this.emp_type = emp_type;
		this.description = description;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeType [ emp_type=" + emp_type + ", description=" + description + ", employee="
				+ employee + "]";
	}
	
	
}
