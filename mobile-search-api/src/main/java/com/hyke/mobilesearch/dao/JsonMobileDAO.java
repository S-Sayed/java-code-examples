package com.hyke.mobilesearch.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hyke.mobilesearch.model.Handset;

@Component
public class JsonMobileDAO implements MobileDAO {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${mobile.handsets.service.url}")
	private String mobileHandsetServicesUrl;

	public List<Handset> findAll() {
		ResponseEntity<Handset[]> response = restTemplate.getForEntity(mobileHandsetServicesUrl, Handset[].class);
		return Arrays.asList(response.getBody());
	}
}
