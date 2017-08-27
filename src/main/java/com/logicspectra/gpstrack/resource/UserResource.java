package com.logicspectra.gpstrack.resource;

public class UserResource {

	protected String email;
	protected String firstName;
	protected String lastName;
	protected String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserResource [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}

}
