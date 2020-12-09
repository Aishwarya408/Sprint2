package com.backend.crud.folder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class User {
	@Id
	private int userId;
	private String password;

	private String firstName;

	private String lastName;

	private String email;

	private String contactno;
	 @PrimaryKeyJoinColumn
	    private int surveyorid;

	public User() {
		super();
	}

	public User(int userId, String password, String firstName, String lastName, String email, String contactno) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
	}
	

	public User(int userId, String password, String firstName, String lastName, String email, String contactno,
			Surveyor surveyor) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
		this.surveyorid = surveyor.getId();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	

	public int getSurveyorid() {
		return surveyorid;
	}

	public void setSurveyorid(int surveyorid) {
		this.surveyorid = surveyorid;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", contactno=" + contactno + ", surveyorid=" + surveyorid + "]";
	}

	
	
	

}