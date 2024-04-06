package com.employee.EmployeeManagement.controller;

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

import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.entity.EmployeeCopy;
import com.employee.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping("/getEmployee")
	public ResponseEntity<Object> getEmployee(@RequestHeader String email) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(employeeService.getEmployee(email));
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Object> editEmployee(@RequestBody EmployeeCopy employeeCopy) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(employeeService.editemployee(employeeCopy));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("login")
	public ResponseEntity<Object> empLogin(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<Object>(employeeService.loginEmp(email, password),HttpStatus.FOUND);
	}
	
	
	
	@GetMapping("resetpasswordmail")
	public ResponseEntity<String> resetpasswordForMail(@RequestHeader String email){
		return new ResponseEntity<String>(employeeService.sendMailForResetPassword(email),HttpStatus.OK);
	}
	
	@PutMapping("resetpassword")
	public ResponseEntity<String> resetpassword(@RequestHeader String email,@RequestHeader String password){
		return new ResponseEntity<String>(employeeService.resetPassword(email,password),HttpStatus.OK);
	}
	
	//create employee
	@PostMapping
	public ResponseEntity<Object> createEmployee(Employee employee){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
