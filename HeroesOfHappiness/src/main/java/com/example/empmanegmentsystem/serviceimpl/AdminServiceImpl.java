package com.example.empmanegmentsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.empmanegmentsystem.entity.Admin;
import com.example.empmanegmentsystem.exception.AdminNotFoundExcption;
import com.example.empmanegmentsystem.repo.AdminRepo;
import com.example.empmanegmentsystem.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	JavaMailSender mail;
	@Autowired
	AdminRepo adminRepo;
	
	BCryptPasswordEncoder b =  new BCryptPasswordEncoder();

	@Override
	public Admin loginAdmin(String email, String password) {
		Admin ad =  adminRepo.findByEmail(email);
		if(ad != null) {
			if(b.matches(password, ad.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(ad.getEmail());
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
				return ad;
			}
		}
		throw new AdminNotFoundExcption("Admin", "email", email);
	}

	@Override
	public String saveAdmin(Admin a) {
		String pswd = b.encode(a.getPassword());
		a.setPassword(pswd);
		adminRepo.save(a);
		return "save";
	}

	@Override
	public String sendMailForResetPassword(String email) {
		Admin admin =  adminRepo.findByEmail(email);
		if(admin != null) {
			SimpleMailMessage ms =  new SimpleMailMessage();
			ms.setTo(admin.getEmail());
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

			return admin.getEmail();
		}
		throw new AdminNotFoundExcption("Admin", "email", email);
	}


	@Override
	public String resetpassword(String email,String password) {
		
		Admin admin =  adminRepo.findByEmail(email);
		if(admin != null) {
			String pswd =  b.encode(password);
			admin.setPassword(pswd);
			adminRepo.save(admin);
			return "reset password successfully";
		}
		return null;
	}

}
