package com.logicspectra.gpstrack.server;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicspectra.gpstrack.resource.UserResource;

@Entity
@Table(name = "appuser")
public class UserEntity {

	@Id
	protected String email;

	protected String firstName;
	protected String lastName;

	protected String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserResource toUserResource() {
		UserResource userResource = new UserResource();
		userResource.setEmail(email);
		userResource.setFirstName(firstName);
		userResource.setLastName(lastName);
		userResource.setPassword(password);
		return userResource;
	}

}
