package com.canturet.springbootcrud.service;

import java.util.List;

import com.canturet.springbootcrud.model.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
