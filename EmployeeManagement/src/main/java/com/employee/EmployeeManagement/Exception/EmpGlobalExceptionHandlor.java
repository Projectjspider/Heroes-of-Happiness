package com.employee.EmployeeManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class EmpGlobalExceptionHandlor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = EmpNotFoundException.class)
	ResponseEntity empNotFound(EmpNotFoundException e) {
	//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		return new ResponseEntity<>(e.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = AdminNotFoundExcption.class)
	ResponseEntity adminNotFound(AdminNotFoundExcption a) {
	return new ResponseEntity<>(a.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ManagerNotFoundException.class)
	ResponseEntity adminNotFound(ManagerNotFoundException m) {
	return new ResponseEntity<>(m.getMsg(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = HrNotFoundException.class)
	ResponseEntity hrNotFound(HrNotFoundException h) {
	return new ResponseEntity<>(h.getMsg(),HttpStatus.NOT_FOUND);
	}
	
}