package com.employee.EmployeeManagement.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.Exception.EmpNotFoundException;
import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.entity.EmployeeCopy;
import com.employee.EmployeeManagement.repo.EmployeeRepo;
import com.employee.EmployeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	JavaMailSender mail;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	
	public Employee getEmployee(String email) {
		Employee employee=employeeRepo.findByEmail(email);
		if(employee!=null) {
			return employee;
		}
		
			throw new EmpNotFoundException("Employee", "email", email) ;

//		Employee employee=employeeRepo.findByEmail(email)
//				.orElseThrow(()->new EmpNotFoundException("Employee","Email", email));
//		return employee;
	}
	
	public Employee editemployee(EmployeeCopy employeeCopy) {
		Employee employee=new Employee(employeeCopy);
		Employee dbEmployee=employeeRepo.findByEmail(employeeCopy.getEmail());
		if(dbEmployee!=null) {
			employee.setPassword(b.encode(employee.getPassword()));
			employee.setEmpid(dbEmployee.getEmpid());
			return employeeRepo.save(employee);
		}
		else {
			throw new RuntimeException();
		}
	}
	
	public Employee loginEmp(String email, String password) {
		Employee emp =  employeeRepo.findByEmail(email);
		
		if(emp != null) {
			if(b.matches(password, emp.getPassword())) {
//			if(password.equals(emp.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(emp.getEmail());
				ms.setFrom("projectjspider@gmail.com");
				ms.setSubject("OTP for login");
				ms.setText("Hello\r\n"
						+ "\r\n"
						+ "This is your OTP(One time password) for login.Please use this for login."
						+ "OTP : "+otp+""
						+ "\r\n"
						+ "\r\n"
						+ "Thanks & Regards\r\n"
						+ "ABS Technologies");
				mail.send(ms);
				return emp;
			}
		}
		throw new EmpNotFoundException("Employee", "Email", email);
	}

	public String sendMailForResetPassword(String email) {
		Employee emp =  employeeRepo.findByEmail(email);
		if(emp != null) {
			SimpleMailMessage ms =  new SimpleMailMessage();
			ms.setTo(emp.getEmail());
			ms.setFrom("projectjspider@gmail.com");
			ms.setSubject("For ResetPassword");
			ms.setText("\"Hello\r\n"
					+ "\r\n"
					+"This is your Link for resetpassword.Please use this link for Setpassword.\"\r\n"
					+"Link : "
					+"\r\n\r\n"
					+"Thanks & Regards\r\n\r\n"
					+"ABS Technologies");
			mail.send(ms);

			return emp.getEmail();
		}
		throw new EmpNotFoundException("Employee", "Email", email) ;
	}

	public String resetPassword(String email, String password) {
		Employee emp =  employeeRepo.findByEmail(email);
		if(emp != null) {
			String pswd =  b.encode(password);
			emp.setPassword(pswd);
			employeeRepo.save(emp);
			return "reset password successfully";
		}
		return null;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

}
