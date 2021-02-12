package com.project.employeeManagementSystem.Service;

import java.util.List; 


public interface ServiceClass <T> {
	
	public List<T> get(); 
	
	public T findById(int t);
	
	public void post(T t);
	
	public T update(T t);
	
	public void delete(int t);

}
