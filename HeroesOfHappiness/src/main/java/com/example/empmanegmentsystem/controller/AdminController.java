package com.example.empmanegmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmanegmentsystem.entity.Admin;
import com.example.empmanegmentsystem.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("save")
	public ResponseEntity<String> adminSave(@RequestBody Admin a){
		return new ResponseEntity<String>(adminService.saveAdmin(a),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("login")
	public ResponseEntity<Admin> adminLogin(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<Admin>(adminService.loginAdmin(email, password),HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("resetpassordmail")
	public ResponseEntity<String> resetpasswordForMail(@RequestHeader String email){
		return new ResponseEntity<String>(adminService.sendMailForResetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("resetpassword")
	public ResponseEntity<String> resetpassword(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<String>(adminService.resetpassword(email,password),HttpStatus.OK);
	}
}
