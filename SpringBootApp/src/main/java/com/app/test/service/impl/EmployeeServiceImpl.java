package com.app.test.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.app.test.exception.ResourceNotFoundException;
import com.app.test.model.Employee;
import com.app.test.repository.EmployeeRepository;
import com.app.test.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	//add employee 
	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	//get all employee
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	
	//get employee by id
	@Override
	public Employee getEmployeeByID(long id) {
		Optional<Employee> EMP= employeeRepository.findById(id);
		if(EMP.isPresent()) {
			return EMP.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	//update Employee
	@Override
	public Employee updateEmployee(Employee emp, long id) {
		//check employee is present or not in DB
		Employee ExixtingEmp= employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id",id));
				ExixtingEmp.setFirstName(emp.getFirstName());
				ExixtingEmp.setLastName(emp.getLastName());
				ExixtingEmp.setEmail(emp.getEmail());
				//save existing employee in DB
				employeeRepository.save(ExixtingEmp);
		return ExixtingEmp;
	}

	//delete employee
	@Override
	public void deleteEmployee(long id) {
		//check if employee is present or not in DB
		employeeRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
