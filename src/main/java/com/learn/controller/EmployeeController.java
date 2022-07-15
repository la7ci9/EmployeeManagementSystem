package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.entity.Employee;
import com.learn.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/add")
	public String createNewStudent(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create_employee";
	}
	@PostMapping("employees")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		employeeService.saveEmployee(emp);
		return "redirect:employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "update_employee";
	}
	
	//if you press the button in edit 
	@PostMapping("/employees/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("employee") Employee emp, Model model) {
		
		Employee existingStudent = employeeService.getEmployeeById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(emp.getFirstName());
		existingStudent.setLastName(emp.getLastName());
		existingStudent.setPhoneNumber(emp.getPhoneNumber());
		existingStudent.setEmail(emp.getEmail());
		existingStudent.setPosition(emp.getPosition());
		
		employeeService.saveEmployee(existingStudent);
		return "redirect:/employees";
	}
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
