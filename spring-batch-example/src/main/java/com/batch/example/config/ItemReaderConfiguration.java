package com.batch.example.config;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.batch.example.model.Customer;

@Configuration
public class ItemReaderConfiguration {
	Logger log = LoggerFactory.getLogger(ItemReaderConfiguration.class);

	@Bean(name = "customerItemReader")
	public ItemReader<Customer> customerItemReader() throws FileNotFoundException {
		log.info("customerItemReader - Thread Name: {}", Thread.currentThread().getName());

		FlatFileItemReader<Customer> flatFileItemReader = new FlatFileItemReader<Customer>();
		String filePath = getClass().getClassLoader().getResource("customers.csv").getFile();
		log.info("customerItemReader - file: {}", filePath);
		flatFileItemReader.setResource(new FileSystemResource(filePath));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setStrict(false);
		flatFileItemReader.setName("Customers-File");
		flatFileItemReader.setLineMapper(buildLineMapper());
		return flatFileItemReader;
	}

	private LineMapper<Customer> buildLineMapper() {
		DefaultLineMapper<Customer> defaultLineMapper = new DefaultLineMapper<Customer>();
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setNames(new String[] { "id", "name", "mobileNumber", "email" });

		BeanWrapperFieldSetMapper<Customer> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Customer>();
		beanWrapperFieldSetMapper.setTargetType(Customer.class);

		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		return defaultLineMapper;
	}

}
