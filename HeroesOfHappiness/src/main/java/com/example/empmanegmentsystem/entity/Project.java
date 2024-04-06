package com.example.empmanegmentsystem.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int project_id;
	private String name;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate start_date;
	private String duration;
	private String project_mgr;
	private int no_emp;
//
//	@Column(nullable = false)
//	private String client_name;

//	@ManyToMany(mappedBy = "project")
//	java.util.List<Employee> emp;
//
//	@JoinColumn(name ="client_id")
//	@ManyToOne(cascade = CascadeType.ALL)
//	Client client;

//	public java.util.List<Employee> getEmp() {
//		return emp;
//	}
//	public void setEmp(java.util.List<Employee> emp) {
//		this.emp = emp;
//	}
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getProject_mgr() {
		return project_mgr;
	}
	public void setProject_mgr(String project_mgr) {
		this.project_mgr = project_mgr;
	}
	public int getNo_emp() {
		return no_emp;
	}
	public void setNo_emp(int no_emp) {
		this.no_emp = no_emp;
	}

//public String getClient_name() {
//		return client_name;
//	}
//	public void setClient_name(String client_name) {
//		this.client_name = client_name;
//	}

}
