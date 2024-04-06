package com.example.empmanegmentsystem.service;

import com.example.empmanegmentsystem.entity.Admin;

public interface AdminService {
	public String saveAdmin(Admin a);
	public Admin loginAdmin(String email,String password);
	public String sendMailForResetPassword(String email);
	public String resetpassword(String email,String password);
}
