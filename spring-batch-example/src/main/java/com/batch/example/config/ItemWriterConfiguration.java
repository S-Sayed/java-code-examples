package com.batch.example.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.example.model.Customer;
import com.batch.example.repo.CustomerRepo;

@Configuration
public class ItemWriterConfiguration {
	Logger log = LoggerFactory.getLogger(ItemWriterConfiguration.class);

	@Autowired
	private CustomerRepo customerRepo;

	@Bean(name = "cusotmerItemWriter")
	public ItemWriter<Customer> cusotmerItemWriter() {
		return new ItemWriter<Customer>() {

			public void write(List<? extends Customer> customers) throws Exception {
				log.info("cusotmerItemWriter - Thread Name: {}", Thread.currentThread().getName());
				log.info("customers-size: {}", customers != null ? customers.size() : 0);

				customerRepo.saveAll(customers);
			}
		};
	}
}
