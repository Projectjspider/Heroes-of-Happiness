package com.employee.EmployeeManagement.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	private String p_name;
	private Date startdate;
	private String p_duration;
	private int no_of_emp;
	private String promgrname;
	
//	@ManyToOne
//	@JoinColumn(name = "pmgr_id")
//	private Employee employee;
//	
//	@ManyToOne
//	@JoinColumn(name = "client_id")
//	private Client client;
}
