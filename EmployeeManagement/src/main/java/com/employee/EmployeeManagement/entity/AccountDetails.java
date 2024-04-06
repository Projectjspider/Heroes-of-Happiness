package com.employee.EmployeeManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String accholder;
	
	@Column(name = "acc_no")
	private long accountnumber;
	
	@Column(name = "bankname")
	private String bankname;
	
	@Column(name = "ifsc_code")
	private long ifsccode;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "pfacc")
	private long pfaccount;
	
	@Column(name = "pfbalance")
	private double pfbalance;
	
//	@OneToOne
//	@JoinColumn(name="e_id")
//	private Employee employee;
	
	
}
