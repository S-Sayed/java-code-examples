package com.batch.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/job")
public class JobController {
	Logger log = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("customerJob")
	private Job customerJob;

	@GetMapping(value = "/startCustomerJob")
	public String startCustomerJob() {
		try {
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("start_time", new JobParameter(System.currentTimeMillis()));
			JobParameters parameters = new JobParameters(params);

			JobExecution jobExecution = jobLauncher.run(customerJob, parameters);
			log.info("controller - Thread Name: {}", Thread.currentThread().getName());
			return jobExecution.getStatus().name();
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong: " + e.getMessage());
		}
	}
}
