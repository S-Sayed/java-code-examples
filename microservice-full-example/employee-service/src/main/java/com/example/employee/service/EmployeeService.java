package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.respository.EmployeeRespository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRespository employeeRespository;

	public List<Employee> getAll() {
		return employeeRespository.findAll();
	}

	public Employee getById(long id) {
		return employeeRespository.findOne(id);
	}

	public void create(Employee e) {
		employeeRespository.save(e);
	}

	public void delete(long id) {
		employeeRespository.delete(id);
	}

	public void update(Employee e) {
		employeeRespository.save(e);
	}
}
