package com.preetham.centime.api.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Person {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$")
	private String firstName;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z ]+$")
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName ;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
