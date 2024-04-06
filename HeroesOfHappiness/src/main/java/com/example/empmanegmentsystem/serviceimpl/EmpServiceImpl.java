package com.example.empmanegmentsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empmanegmentsystem.entity.Employee;
import com.example.empmanegmentsystem.exception.ManagerNotFoundException;
import com.example.empmanegmentsystem.repo.EmpRepo;
import com.example.empmanegmentsystem.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	JavaMailSender mail;
	@Autowired
	EmpRepo empRepo;
	
	BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
	

	@Override
	public Employee loginEmp(String email, String password) {
		Employee emp =  empRepo.findByEmail(email);
		if(emp != null) {
			if(b.matches(password, emp.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(emp.getEmail());
				ms.setFrom("javabiswa12@gmail.com");
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
		throw new ManagerNotFoundException("Employee", "Email", email);
	}

	@Override
	public String sendMailForResetPassword(String email) {
		Employee emp =  empRepo.findByEmail(email);
		if(emp != null) {
			SimpleMailMessage ms =  new SimpleMailMessage();
			ms.setTo(emp.getEmail());
			ms.setFrom("javabiswa12@gmail.com");
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
		throw new ManagerNotFoundException("Employee", "Email", email) ;
	}

	@Override
	public String resetPassword(String email, String password) {
		Employee emp =  empRepo.findByEmail(email);
		if(emp != null) {
			String pswd =  b.encode(password);
			emp.setPassword(pswd);
			empRepo.save(emp);
			return "reset password successfully";
		}
		return null;
	}

}
