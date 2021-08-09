package com.canturet.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.canturet.springbootcrud.model.Employee;
import com.canturet.springbootcrud.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/personel-ekle")
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/personel-kaydet")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/personel-guncelle/{id}")
	public String updateEmployeeForm(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	@GetMapping("/personel-sil/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
