package com.employee.EmployeeManagement.entity;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeCopy {

    private String empname;
	
	@Pattern(regexp ="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	private String password;
	
	private String designation;
	
	private String pname;
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	
	private double salary;
	
	private String gender;
	
	private LocalDate hiredate;
		
	private boolean mgr;
	
	private String mgrname;
	
	private boolean hr;
	
	private int hid;
		
	private int mid;	
	
	private String address;
	
	private Blob profileimage;
	
	private String status;
	
//	@OneToMany(mappedBy = "employee")
//	private List<Project> project;
}
