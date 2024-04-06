package com.example.empmanegmentsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.empmanegmentsystem.entity.Employee;
import com.example.empmanegmentsystem.exception.ManagerNotFoundException;
import com.example.empmanegmentsystem.repo.HrRepo;
import com.example.empmanegmentsystem.service.HrService;
@Service
public class HrServiceImpl implements HrService {
	@Autowired
	JavaMailSender mail;
	
	@Autowired
	HrRepo hrRepo;
	
	BCryptPasswordEncoder b =  new BCryptPasswordEncoder();

	@Override
	public Employee loginHr(String email, String password) {
		Employee hr =  hrRepo.findByEmail(email);
		if(hr != null) {
			if(b.matches(password, hr.getPassword())) {
				int otp =(int)(Math.random()*10000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(hr.getEmail());
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
				return hr;
			}
		}
		throw new ManagerNotFoundException("Hr", "Email", email);
	}

	@Override
	public String sendMailForResetPassword(String email) {
		Employee hr =  hrRepo.findByEmail(email);
		if(hr != null) {
			SimpleMailMessage ms =  new SimpleMailMessage();
			ms.setTo(hr.getEmail());
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

			return hr.getEmail();
		}
		throw new ManagerNotFoundException("Hr", "Email", email) ;
	}


	@Override
	public String resetPassword(String email, String password) {
		Employee hr =  hrRepo.findByEmail(email);
		if(hr != null) {
			String pswd =  b.encode(password);
			hr.setPassword(pswd);
			hrRepo.save(hr);
			return "reset password successfully";
		}
		return null;
	}

}
