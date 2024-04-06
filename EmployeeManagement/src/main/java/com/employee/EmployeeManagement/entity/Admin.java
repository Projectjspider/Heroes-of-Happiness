package com.employee.EmployeeManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a_id;
	
	@Column(name = "admin_name")
	private String name;
	
	@Column(name = "a_email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
}
