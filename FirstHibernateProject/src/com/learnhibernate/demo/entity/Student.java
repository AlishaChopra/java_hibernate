package com.learnhibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="stud_id")
	private int studId;
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	@Column(name="email")
	private String email;
	public Student(){
		
	}
	public Student(String fName, String lName, String email) {
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}
	
	

}
