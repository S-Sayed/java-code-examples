package com.ssayed.examples.behavioral.command;

import java.util.HashMap;
import java.util.Map;

// concrete command
public class MobileNumberSearch extends SearchCommand {

	// no Receiver (business object) provided in this example, the concrete command
	// contain the logic for testing

	public MobileNumberSearch(SearchCriteria searchCriteria) {
		super(searchCriteria);
	}

	@Override
	public SearchResult execute() {
		// if you have receiver, delegate the work to it
		System.out.println("Search by " + super.getSearchCriteria());
		return mockedData(super.getSearchCriteria().getSeachValue());
	}

	private SearchResult mockedData(String seachValue) {
		return getMockedMobileNumbers().get(seachValue);
	}

	private Map<String, SearchResult> getMockedMobileNumbers() {
		Map<String, SearchResult> mockedMobileNumbers = new HashMap<>();

		SearchResult result = new SearchResult();
		result.setId(1);
		result.setName("ADAM SAMEH ELSAYED");
		result.setEmail("ssayed7190@gmail.com");
		result.setMobileNumber("0506630580");
		result.setNationalID("123456789");
		mockedMobileNumbers.put(result.getMobileNumber(), result);

		result = new SearchResult();
		result.setId(2);
		result.setName("SILA SAMEH ELSAYED");
		result.setEmail("silasameh@gmail.com");
		result.setMobileNumber("0123456789");
		result.setNationalID("987654321");
		mockedMobileNumbers.put(result.getMobileNumber(), result);

		return mockedMobileNumbers;
	}
}
