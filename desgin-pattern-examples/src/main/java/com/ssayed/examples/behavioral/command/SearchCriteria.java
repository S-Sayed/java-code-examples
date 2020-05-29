package com.ssayed.examples.behavioral.command;

// request object that contains all the request details
public class SearchCriteria {

	private String searcType;
	private String seachValue;

	public String getSearcType() {
		return searcType;
	}

	public void setSearcType(String searcType) {
		this.searcType = searcType;
	}

	public String getSeachValue() {
		return seachValue;
	}

	public void setSeachValue(String seachValue) {
		this.seachValue = seachValue;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searcType=" + searcType + ", seachValue=" + seachValue + "]";
	}

}
