package com.employee.EmployeeManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.Exception.ManagerNotFoundException;
import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.repo.ManagerRepo;
import com.employee.EmployeeManagement.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	JavaMailSender mail;
	
	@Autowired
	ManagerRepo managerRepo;
	
	BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
	
	@Override
	public int loginManager(String email, String password) {
		Employee mgr =  managerRepo.findByEmail(email);
		if(mgr != null) {
			if(b.matches(password, mgr.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(mgr.getEmail());
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
				return otp;
			}
		}
		throw new ManagerNotFoundException("Manager", "Email", email);
	}
	
	@Override
	public String sendMailForResetPassword(String email) {
		Employee mgr =  managerRepo.findByEmail(email);
		if(mgr != null) {
			SimpleMailMessage ms =  new SimpleMailMessage();
			ms.setTo(mgr.getEmail());
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

			return mgr.getEmail();
		}
		throw new ManagerNotFoundException("Manager", "Email", email) ;
	}


	@Override
	public String resetPassword(String email, String password) {
		Employee mgr =  managerRepo.findByEmail(email);
		if(mgr != null) {
			String pswd =  b.encode(password);
			mgr.setPassword(pswd);
			managerRepo.save(mgr);
			return "reset password successfully";
		}
		return null;
	}

	

}
