package com.employee.EmployeeManagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmpLeave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveid;
	private LocalDate startdate;
	private LocalDate enddate;
	private String reason;
	private int totalleave=50;
	private int remainleave;
}
