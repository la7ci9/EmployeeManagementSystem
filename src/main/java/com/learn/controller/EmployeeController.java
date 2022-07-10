package com.learn.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.entity.Employee;
import com.learn.service.EmployeeService;

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("students/addEmployee")
	public String createNewStudent(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create_employee";
	}
}
