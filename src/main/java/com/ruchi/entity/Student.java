package com.ruchi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="STUDENT_INFO")
public class Student {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="SID")
	private int sid;
	@Column (name="FIRST_NAME")
	private String firstName;
	@Column (name="LAST_NAME")
	private String lastName;
	@Column (name = "EMAIL")
	private String email;
	@Column (name = "PHONE")
	private long	phone;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Student(String firstName, String lastName, String email, long phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
