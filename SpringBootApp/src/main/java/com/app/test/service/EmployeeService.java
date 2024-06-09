package com.app.test.service;

import java.util.List;

import com.app.test.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	List<Employee> getAllEmployee();
	Employee getEmployeeByID(long id);
	Employee updateEmployee(Employee emp,long id);
	void deleteEmployee(long id);
}
