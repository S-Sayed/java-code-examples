package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Value("${server.port}")
	private String port;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	private ResponseEntity<List<Employee>> all() {
		// add the port in the response to check which server handled the request 
		// just for checking the load balancer/ Eureka service functionality 
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Served-Server-Port", port);
		return ResponseEntity.ok().header("Served-Server-Port", port).body(employeeService.getAll());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	private ResponseEntity<Employee> find(@PathVariable final long id) {
		Employee employee = employeeService.getById(id);
		HttpStatus httpStatus = employee == null ?  HttpStatus.NO_CONTENT :  HttpStatus.OK;
		return new ResponseEntity<>(employee, httpStatus);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	private ResponseEntity<HttpStatus> add(@RequestBody final Employee e) {
		if(e == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		employeeService.create(e);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	private ResponseEntity<HttpStatus> update(@RequestBody final Employee e) {
		if(e == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		employeeService.update(e);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	private ResponseEntity<HttpStatus> delete(@PathVariable final long id) {
		employeeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
