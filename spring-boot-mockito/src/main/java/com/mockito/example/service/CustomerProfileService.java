package com.mockito.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockito.example.model.Customer;

@Service
public class CustomerProfileService {

	@Autowired
	EmailNotificationService emailNotificationService;

	public boolean sendEmail(String emailId) {
		return emailNotificationService.send(emailId);
	}

	public List<Customer> getCustomers() {
		return null; // call DAO layer instead
	}

	public boolean addCustomer(Customer customer) {
		return false;
	}

	public boolean updateCustomer(Customer updatedCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCustomerExist(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
