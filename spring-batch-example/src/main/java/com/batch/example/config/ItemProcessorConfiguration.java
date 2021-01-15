package com.batch.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.example.model.Customer;

@Configuration
public class ItemProcessorConfiguration {
	Logger log = LoggerFactory.getLogger(ItemProcessorConfiguration.class);

	@Bean(name = "customerItemProcessor")
	public ItemProcessor<Customer, Customer> customerItemProcessor() {
		return new ItemProcessor<Customer, Customer>() {

			public Customer process(Customer customer) throws Exception {
				log.info("customerItemProcessor - Thread Name: {}", Thread.currentThread().getName());
				log.info("customer-before-processing: {}", customer);

				customer.setName(customer.getName().toUpperCase());
				log.info("customer-after-processing: {}", customer);

				return customer;
			}
		};
	}

}
