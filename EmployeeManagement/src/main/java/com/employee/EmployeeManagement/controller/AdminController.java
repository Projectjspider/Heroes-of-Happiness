package com.employee.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeManagement.entity.Admin;
import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.service.AdminService;
import com.employee.EmployeeManagement.serviceimpl.AdminServiceImpl;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/createadmin")
	public ResponseEntity<Object> createAdmin(@RequestBody Admin admin) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(adminService.createAdmin(admin));		
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/createemployee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.OK).body(adminService.createEmployee(employee));
	}
	
	@GetMapping("/getAdmin")
	public ResponseEntity<Object> getAdmin(@RequestHeader String email){
		return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getAdminByEmail(email));
	}
	
	@PostMapping("save")
	public ResponseEntity<String> adminSave(@RequestBody Admin a){
		return new ResponseEntity<String>(adminService.saveAdmin(a),HttpStatus.CREATED);
	}
	
	
	@GetMapping("login")
	public ResponseEntity<Integer> adminLogin(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<Integer>(adminService.loginAdmin(email, password),HttpStatus.FOUND);
	}
	
	
	@GetMapping("resetpasswordmail")
	public ResponseEntity<String> resetpasswordForMail(@RequestHeader String email){
		return new ResponseEntity<String>(adminService.sendMailForResetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("resetpassword")
	public ResponseEntity<String> resetpassword(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<String>(adminService.resetpassword(email,password),HttpStatus.OK);
	}
}
