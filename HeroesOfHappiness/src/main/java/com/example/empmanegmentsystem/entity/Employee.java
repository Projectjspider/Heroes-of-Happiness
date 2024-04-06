package com.example.empmanegmentsystem.entity;

import java.sql.Blob;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	private String name;
	@Email(regexp = ".*@gmail.com",message = "invalid msg")
	private String email;
	private String password;
	private String designation;
	private String project_name;
	private long phone;
	private double salary;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate hiredate;
	private String mgr;
	private String mgr_name;
	private int mgr_id;
	
	private boolean hr;
	
	private int hr_id;
	private String gender;
	private String addres;
	private Blob profile_pic;
	private String status;
	
//	@JoinTable(name ="emp_project")
//	@ManyToMany(cascade = CascadeType.ALL)
//	java.util.List<Project> project;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getMgr_name() {
		return mgr_name;
	}

	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	public boolean isHr() {
		return hr;
	}

	public void setHr(boolean hr) {
		this.hr = hr;
	}

	public int getHr_id() {
		return hr_id;
	}

	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public Blob getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(Blob profile_pic) {
		this.profile_pic = profile_pic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public java.util.List<Project> getProject() {
//		return project;
//	}
//
//	public void setProject(java.util.List<Project> project) {
//		this.project = project;
//	}

}
