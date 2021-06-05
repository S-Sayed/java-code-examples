package com.hyke.mobilesearch.model;

import java.util.List;

public class SearchResult {

	private int total;
	private List<Handset> handsets;

	public SearchResult(int total, List<Handset> handsets) {
		this.total = total;
		this.handsets = handsets;
	}

	public int getTotal() {
		return total;
	}

	public List<Handset> getHandsets() {
		return handsets;
	}
}
