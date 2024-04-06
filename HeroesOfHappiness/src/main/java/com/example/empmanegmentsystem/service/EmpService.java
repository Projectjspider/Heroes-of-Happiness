package com.example.empmanegmentsystem.service;

import com.example.empmanegmentsystem.entity.Employee;

public interface EmpService {
	public Employee loginEmp(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);
}
