package com.example.empmanegmentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empmanegmentsystem.entity.Employee;
@Repository
public interface HrRepo extends JpaRepository<Employee, Integer> {
	public Employee findByEmail(String email);
}
