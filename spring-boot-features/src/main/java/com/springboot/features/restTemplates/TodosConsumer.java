package com.springboot.features.restTemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/todos")
public class TodosConsumer {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{id}")
	private String getDetailsById(@PathVariable("id") long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			// todos is a public online rest API for developers
			return restTemplate
					.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.GET, entity, String.class)
					.getBody();

		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
