package com.backend.crud.folder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login1")
public class Login1 {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="ID")
	Long id;
	
	@Column(name="LoginName")
	String loginName;
	
	@Column(name="Password")
	String password;
	
	
	public Login1() {
		super();
	}
	
	public Login1(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}
	public Login1(Long id, String loginName, String password) {
		super();
		this.id=id;
		this.loginName = loginName;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Admin{");
		sb.append("id:").append(id).append(",");
		sb.append("loginName:").append(loginName).append(",");
		sb.append("password:").append(password).append(",");
		sb.append("}");
		return sb.toString();
	}
}