package com.ramana.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramana.demo.custom.exception.EmptyInputException;
import com.ramana.demo.entity.Employee;
import com.ramana.demo.repos.EmployeeCrudRepo;



@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		if(employee.getName().isEmpty()||employee.getName().length()==0) {
			throw new EmptyInputException("601","Input fields are empty");
		}
		Employee savedEmployee = crudRepo.save(employee);
		return savedEmployee;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}