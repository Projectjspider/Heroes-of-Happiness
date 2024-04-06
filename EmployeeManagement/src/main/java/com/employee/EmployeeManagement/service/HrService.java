package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.entity.Employee;

public interface HrService {
	public Employee loginHr(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);
}
