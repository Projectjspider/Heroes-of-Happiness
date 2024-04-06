package com.example.empmanegmentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empmanegmentsystem.entity.Employee;
import com.example.empmanegmentsystem.service.HrService;

@RestController
@RequestMapping("hr")
public class HrController {
	@Autowired
	HrService hrService;

	
	
	@GetMapping("login")
	public ResponseEntity<Employee> hr1Login(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<Employee>(hrService.loginHr(email, password),HttpStatus.FOUND);
	}
	
	
	@GetMapping("resetpassordmail")
	public ResponseEntity<String> resetpasswordForMail(@RequestHeader String email){
		return new ResponseEntity<String>(hrService.sendMailForResetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("resetpassword")
	public ResponseEntity<String> resetpassword(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<String>(hrService.resetPassword(email,password),HttpStatus.OK);
	}
	

}
