package com.example.empmanegmentsystem.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private String name;
	private String loc;
	@Email(regexp = ".*@gmail.com",message = "invalid msg")
	private String poc_email;
	private String poc_phn;
//	@OneToMany
//	private List<Project> pro;
//	
	
	public String getPoc_phn() {
		return poc_phn;
	}
	public void setPoc_phn(String poc_phn) {
		this.poc_phn = poc_phn;
	}
//	public List<Project> getPro() {
//		return pro;
//	}
//	public void setPro(List<Project> pro) {
//		this.pro = pro;
//	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getPoc_email() {
		return poc_email;
	}
	public void setPoc_email(String poc_email) {
		this.poc_email = poc_email;
	}
	
	
}
