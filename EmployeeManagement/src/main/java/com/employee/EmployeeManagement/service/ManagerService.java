package com.employee.EmployeeManagement.service;

import com.employee.EmployeeManagement.entity.Employee;

public interface ManagerService {
	public int loginManager(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);

}
