package com.employee.EmployeeManagement.service;

import org.springframework.http.ResponseEntity;

import com.employee.EmployeeManagement.entity.Admin;
import com.employee.EmployeeManagement.entity.Employee;

public interface AdminService {
	public Admin createAdmin(Admin admin); 
	
	public Employee createEmployee(Employee employee);
	
	public String saveAdmin(Admin a);
	public int loginAdmin(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetpassword(String email,String password);

	public Admin getAdminByEmail(String email);
}
