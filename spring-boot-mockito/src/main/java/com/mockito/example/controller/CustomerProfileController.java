package com.mockito.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.example.model.Customer;
import com.mockito.example.service.CustomerProfileService;

@RestController
@RequestMapping("customers")
public class CustomerProfileController {

	@Autowired
	CustomerProfileService customerProfileService;

	@GetMapping
	public ResponseEntity<List<Customer>> all() {
		return new ResponseEntity<>(customerProfileService.getCustomers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer c = customerProfileService.getCustomerById(id);
		return new ResponseEntity<>(c, c != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Boolean> addCustomer(@RequestBody Customer customer) {
		if (customerProfileService.isCustomerExist(customer.getId())) {
			return new ResponseEntity<>(false, HttpStatus.CONFLICT);
		}

		boolean created = customerProfileService.addCustomer(customer);
		return new ResponseEntity<>(created, created ? HttpStatus.CREATED: HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/{name}")
	public ResponseEntity<Boolean> updateCustomer(@PathVariable(name = "name", required = true) String customerName,
			@RequestBody Customer updatedCustomer) {

		if (!(customerProfileService.isCustomerExist(updatedCustomer.getId()))) {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}

		boolean updated = customerProfileService.updateCustomer(updatedCustomer);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
}