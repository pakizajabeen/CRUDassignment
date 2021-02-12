package com.project.employeeManagementSystem.entity;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name ="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	@NotNull(message =" is required")
	private String name;

	@Column(name = "email")
	@NotNull(message =" is required")
	private String email;

	@Column(name = "address")
	@NotNull(message =" is required")
	private String address;
	
	@Column(name = "salary")
	@NotNull(message =" is required")
	private int salary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Department department;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private EmployeeType employeeType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Office office;
	
	public Employee ()
	{
		
	}
	
	
	public Employee(String name, String email, String address, Department department, int salary) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.department = department;
		this.salary=salary;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public EmployeeType getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}


	public Office getOffice() {
		return office;
	}


	public void setOffice(Office office) {
		this.office = office;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", salary="
				+ salary + ", department=" + department + ", employeeType=" + employeeType + ", office=" + office + "]";
	}
	
	

}

