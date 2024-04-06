package com.employee.EmployeeManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeManagement.entity.Employee;

@Repository
public interface HrRepo extends JpaRepository<Employee, Integer> {
	public Employee findByEmail(String email);
}
