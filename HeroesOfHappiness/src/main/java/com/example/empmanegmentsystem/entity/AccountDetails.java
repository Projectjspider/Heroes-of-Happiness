package com.example.empmanegmentsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int acc_id;
	private String acc_name;
	private String bank_name;
	private long acc_no;
	private String ifsc_code;
	private String branch_name;
	private long pf_account;
	private double pf_balance;
	
//	@OneToOne
//	Employee employee;

	

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public double getPf_balance() {
		return pf_balance;
	}

	public void setPf_balance(double pf_balance) {
		this.pf_balance = pf_balance;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public long getPf_account() {
		return pf_account;
	}

	public void setPf_account(long pf_account) {
		this.pf_account = pf_account;
	}

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
}
