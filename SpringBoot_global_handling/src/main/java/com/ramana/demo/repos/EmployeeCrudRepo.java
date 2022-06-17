package com.ramana.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramana.demo.entity.Employee;



public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {
	
	

}
