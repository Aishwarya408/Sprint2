package com.backend.crud.folder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.cg.model.Address;

//import com.cg.model.Address;

@Entity         //One of the mandatory annotations. This annotation indicates that this class is a entity class
@Table(name="surveyor_main_table")            // @Table annotation is used to declare the table name 
public class Surveyor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String userName;      //Username is declared as primary key
	private String userPassword;
	private String firstName;
	private String Lastname;
	private String role;
	private String email;

	private String phone;
	

	
	public Surveyor() {        // zero-parametized constructor
		super();
	}
	
	public Surveyor(int id, String userName, String userPassword, String firstName, String lastname, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		Lastname = lastname;
		this.role = role;
	}

	public Surveyor(String userName, String userPassword, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.role = role;
	}
	
	public Surveyor(String userName, String userPassword, String firstName, String lastname, String role) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		Lastname = lastname;
		this.role = role;
	}
	
	

	

	public Surveyor(int id, String userName, String userPassword, String firstName, String lastname, String role,
			String email, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		Lastname = lastname;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Surveyor [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", firstName="
				+ firstName + ", Lastname=" + Lastname + ", role=" + role + ", email=" + email + ", phone=" + phone
				+ "]";
	}

	
	

}
