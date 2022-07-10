package com.learn.service;

import java.util.List;

import com.learn.entity.Employee;

public interface EmployeeServiceDAO {

	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee emp);
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee emp);
	
	void deleteEmployeeById(Long id);
}
