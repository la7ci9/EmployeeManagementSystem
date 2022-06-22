package com.learn.service;

import java.util.List;

import com.learn.entity.Employee;
import com.learn.repository.EmployeeRepository;

public class EmployeeService implements EmployeeServiceDAO {

	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	

}
