package com.example.empmanegmentsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empmanegmentsystem.entity.Admin;
import com.example.empmanegmentsystem.entity.Employee;
import com.example.empmanegmentsystem.exception.AdminNotFoundExcption;
import com.example.empmanegmentsystem.exception.ManagerNotFoundException;
import com.example.empmanegmentsystem.repo.ManagerRepo;
import com.example.empmanegmentsystem.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	JavaMailSender mail;
	
	@Autowired
	ManagerRepo managerRepo;
	
	BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
	
	@Override
	public Employee loginManager(String email, String password) {
		Employee mgr =  managerRepo.findByEmail(email);
		if(mgr != null) {
			if(b.matches(password, mgr.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(mgr.getEmail());
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
				return mgr;
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
