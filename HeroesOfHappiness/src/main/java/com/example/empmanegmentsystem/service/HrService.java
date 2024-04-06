package com.example.empmanegmentsystem.service;

import com.example.empmanegmentsystem.entity.Employee;

public interface HrService {
	public Employee loginHr(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetPassword(String email,String password);
}
