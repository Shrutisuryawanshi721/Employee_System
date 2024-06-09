package com.app.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.test.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
