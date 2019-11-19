package com.mockito.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.example.controller.CustomerProfileController;
import com.mockito.example.model.Customer;
import com.mockito.example.service.CustomerProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestControllerTest {

	private MockMvc mockMvc;

	@InjectMocks // inject the mocks in this object automatically
	CustomerProfileController customerProfileController;

	@Mock // mock this object i.e provide dummy data
	CustomerProfileService customerProfileService;

	@Before
	public void init() {
		// build mockMvc instance by registering 1+ rest controller instances
		// and
		// configure the Spring MVC infrastructure programmatically
		mockMvc = MockMvcBuilders.standaloneSetup(customerProfileController).build();
	}

	@Test
	public void getAllCustomers() throws Exception {
		List<Customer> mockedCustomerList = new ArrayList<Customer>();
		mockedCustomerList.add(new Customer(1, "Sameh1"));
		mockedCustomerList.add(new Customer(2, "Sameh2"));

		when(customerProfileService.getCustomers()).thenReturn(mockedCustomerList);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				// jsonpath is used to access the response body in JSON format
				.andExpect(jsonPath("$[0].id", is(1))).andReturn();

		// int expectedStatusCode = 200;
		// assertEquals(expectedStatusCode, result.getResponse().getStatus());
		System.out.println("Customers = " + result.getResponse().getContentAsString());
		// int expectedCustomerLength = 4;
		// assertEquals(expectedCustomerLength,
		// result.getResponse().getContentAsString().split(",").length);

		// verify that getCustomers() method of customerProfileService is
		// invoked once
		verify(customerProfileService, times(1)).getCustomers();
		// verify that after the response returned, no more interactions are
		// made to customerProfileService
		verifyNoMoreInteractions(customerProfileService);
	}

	@Test
	public void ifCustomerIdIsProvided_ThenReturnCustomerDerailsIfFound() throws Exception {
		Long customerId = 1L;
		Customer c = new Customer(1, "Sameh1");
		when(customerProfileService.getCustomerById(customerId)).thenReturn(c);

		mockMvc.perform(get("/customers/{id}", customerId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.name", is("Sameh1")));
	}

	@Test
	public void ifCustomerIdIsProvided_ThenReturnNotFoundStatus() throws Exception {
		Long customerId = 1L;
		when(customerProfileService.getCustomerById(customerId)).thenReturn(null);

		mockMvc.perform(get("/customers/{id}", customerId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void addNewCustomer_IfCreated_returnCreated() throws Exception {
		Customer newCustomer = new Customer(1, "sabah");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(newCustomer);
		System.out.println(json);

		when(customerProfileService.isCustomerExist(newCustomer.getId())).thenReturn(false);
		// when(customerProfileService.addCustomer(newCustomer)).thenReturn(true);
		doReturn(true).when(customerProfileService).addCustomer(newCustomer);

		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.post("/customers").contentType(MediaType.APPLICATION_JSON).content(json))
				// spring mockito code provide builder methods
				.andExpect(status().isCreated()).andReturn();
	}

	@Test
	public void addNewCustomer_IfNotCreated_returnError() throws Exception {
		Customer newCustomer = new Customer(1, "sabah");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(newCustomer);
		System.out.println(json);

		when(customerProfileService.isCustomerExist(newCustomer.getId())).thenReturn(false);
		// when(customerProfileService.addCustomer(newCustomer)).thenReturn(true);
		doReturn(false).when(customerProfileService).addCustomer(newCustomer);

		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.post("/customers").contentType(MediaType.APPLICATION_JSON).content(json))
				// spring mockito code provide builder methods
				.andExpect(status().isInternalServerError()).andReturn();

		// junit code
		int expectedStatusCode = 500;
		assertEquals(expectedStatusCode, result.getResponse().getStatus());
		String expectedResult = "false";
		assertEquals(expectedResult, result.getResponse().getContentAsString());

		verify(customerProfileService, times(1)).isCustomerExist(newCustomer.getId());
		verify(customerProfileService, times(1)).addCustomer(newCustomer);
		verifyNoMoreInteractions(customerProfileService);
	}
}
