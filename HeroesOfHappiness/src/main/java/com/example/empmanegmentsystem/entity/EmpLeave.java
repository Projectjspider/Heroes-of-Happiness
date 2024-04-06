package com.example.empmanegmentsystem.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class EmpLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int l_id;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate start_date;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate end_date;
	private String reason;
	private int total_leave =50;

	private int remaining_leave;
//	@OneToOne
//	Employee employee;
//	
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getTotal_leave() {
		return total_leave;
	}

	public void setTotal_leave(int total_leave) {
		this.total_leave = total_leave;
	}

	public int getRemaining_leave() {
		return remaining_leave;
	}

	public void setRemaining_leave(int remaining_leave) {
		this.remaining_leave = remaining_leave;
	}


}
