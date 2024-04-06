package com.example.empmanegmentsystem.service;

import com.example.empmanegmentsystem.entity.Admin;

import com.example.empmanegmentsystem.entity.Employee;

public interface ManagerService {
	public Employee loginManager(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);

}
