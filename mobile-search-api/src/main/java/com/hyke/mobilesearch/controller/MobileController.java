package com.hyke.mobilesearch.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hyke.mobilesearch.model.Handset;
import com.hyke.mobilesearch.model.SearchResult;
import com.hyke.mobilesearch.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileService mobileService;

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public SearchResult search(@RequestParam Map<String, String> queryParameters) {
		List<Handset> returnedHandsets = mobileService.search(queryParameters);
		return new SearchResult(returnedHandsets.size(), returnedHandsets);
	}
}