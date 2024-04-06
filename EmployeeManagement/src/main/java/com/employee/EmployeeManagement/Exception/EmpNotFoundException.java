package com.employee.EmployeeManagement.Exception;

import lombok.Data;

@Data
public class EmpNotFoundException extends RuntimeException{
	private String entity;
	private String attribute;
	private String value;
	private String msg ="Emp Not Found For above Details";
	
	
	public EmpNotFoundException(String entity, String attribute, String value) {
		super();
		this.entity = entity;
		this.attribute = attribute;
		this.value = value;
	}
//	public EmpNotFoundException(String email) {
//		this.msg="No emplyee found with email : "+email;
//	}
}
