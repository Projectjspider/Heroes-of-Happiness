package com.example.empmanegmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmanegmentsystem.entity.Admin;
import com.example.empmanegmentsystem.entity.Employee;
import com.example.empmanegmentsystem.service.AdminService;
import com.example.empmanegmentsystem.service.ManagerService;

@RestController
@RequestMapping("manager")
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	
	@GetMapping("login")
	public ResponseEntity<Employee> empLogin(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<Employee>(managerService.loginManager(email, password),HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("resetpassordmail")
	public ResponseEntity<String> resetpasswordForMail(@RequestHeader String email){
		return new ResponseEntity<String>(managerService.sendMailForResetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("resetpassword")
	public ResponseEntity<String> resetpassword(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<String>(managerService.resetPassword(email,password),HttpStatus.OK);
	}
}
