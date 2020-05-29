package com.ssayed.examples.behavioral.command;

// command contract abstract class/ interface
public abstract class SearchCommand {

	// input object to the method defined in the concrete command/ receiver
	private SearchCriteria searchCriteria;

	public SearchCommand(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public abstract SearchResult execute();

	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}
}
