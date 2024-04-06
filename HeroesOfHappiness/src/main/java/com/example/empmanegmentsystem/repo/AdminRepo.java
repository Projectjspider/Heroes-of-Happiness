package com.example.empmanegmentsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.empmanegmentsystem.entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	public Admin findByEmail(String email);
}
