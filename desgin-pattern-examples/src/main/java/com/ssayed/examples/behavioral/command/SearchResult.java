package com.ssayed.examples.behavioral.command;

// command response
public class SearchResult {

	private long id;
	private String name;
	private String mobileNumber;
	private String email;
	private String nationalID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	@Override
	public String toString() {
		return "SearchResult [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", nationalID=" + nationalID + "]";
	}

}
