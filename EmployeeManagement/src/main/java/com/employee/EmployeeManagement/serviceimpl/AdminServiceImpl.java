package com.employee.EmployeeManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.Exception.AdminNotFoundExcption;
import com.employee.EmployeeManagement.entity.Admin;
import com.employee.EmployeeManagement.entity.Employee;
import com.employee.EmployeeManagement.repo.AdminRepo;
import com.employee.EmployeeManagement.repo.EmployeeRepo;
import com.employee.EmployeeManagement.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired(required = true)
	JavaMailSender javaMailSender;
	
    BCryptPasswordEncoder b=new BCryptPasswordEncoder();
	
	@Override
	public Admin createAdmin(Admin admin) {
		Admin admin1=adminRepo.save(admin);
		return admin1;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		 String password="Abs";
		 int otp=(int)(Math.random()*100000);
		 password=password+otp;
		 employee.setPassword(password);
		 Employee dbEmployee=employeeRepo.save(employee);
		 
		 SimpleMailMessage message=new SimpleMailMessage();
		 message.setFrom("projectjspider@gmail.com");
		 message.setTo(employee.getEmail());
		 message.setSubject("Welcome to ABS Technologies - Your Credentials Inside!");
		 message.setText("Hello, \r\n"
		 		+ "\r\n"
		 		+ "Welcome aboard to ABS Technologies! We're thrilled to have you join our team and embark on this exciting journey with us."
		 		+ "\r\n"
		 		+ ""
		 		+ "Below are your login credentials for accessing our company systems:\r\n"
		 		+ "\r\n"
		 		+ "Username : "+employee.getEmail() +"\r\n"
		 		+ "Temporary Password : "+employee.getPassword()+"\r\n"
		 		+ "Access Link : [Link to Access Company Systems]"
		 		+ "\r\n"
		 		+"\r\n"
		 		+ "Please note that for security reasons, we recommend changing your password upon your first login. To do so, simply follow the prompts provided on the login page."
		 		+ ""
		 		+ "\r\n"
		 		+ "\r\n"
		 		+ "\r\n"
		 		+ "Thanks & Regards\r\n"
		 		+ "ABS Technologies");
		 
		 javaMailSender.send(message);
		 return dbEmployee;
	}
	
	
	@Override
	public int loginAdmin(String email, String password) {
		Admin ad =  adminRepo.findByEmail(email);
		if(ad != null) {
//			if(b.matches(password, ad.getPassword())) {
			if(password.equals(ad.getPassword())) {
				int otp =(int)(Math.random()*1000000);
				SimpleMailMessage ms =  new SimpleMailMessage();
				ms.setTo(ad.getEmail());
				ms.setFrom("projectjspider@gmail.com");
				ms.setSubject("OTP for login");
				ms.setText("Hello\r\n"
						+ "\r\n\r\n"
						+ "This is your OTP(One time password) for login.Please use this for login.\r\n"
						+ "OTP : "+otp+""
						+ "\r\n"
						+ "\r\n"
						+ "Thanks & Regards\r\n"
						+ "ABS Technologies");
				javaMailSender.send(ms);
				return otp;
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
			ms.setFrom("projectjspider@gmail.com");
			ms.setSubject("For ResetPassword");
			ms.setText("Hello\r\n"
					+ "\r\n"
					+"This is your Link for resetpassword.Please use this link for Setpassword.\r\n"
					+"Link : "
					+"\r\n\r\n"
					+"Thanks & Regards\r\n\r\n"
					+"ABS Technologies");
			javaMailSender.send(ms);

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

	@Override
	public Admin getAdminByEmail(String email) {
		Admin admin=adminRepo.findByEmail(email);
		if(admin!=null) {
			return admin;
		}
		throw new AdminNotFoundExcption("Admin", "Email", email);
	}


}
