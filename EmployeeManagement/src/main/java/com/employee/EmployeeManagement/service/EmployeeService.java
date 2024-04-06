package com.employee.EmployeeManagement.service;


import java.util.Optional;

import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.entity.EmployeeCopy;

public interface EmployeeService {
	public Employee getEmployee(String email);
	public Employee editemployee(EmployeeCopy employeeCopy);
	public int loginEmp(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);
	public Employee createEmployee(Employee employee);
}
