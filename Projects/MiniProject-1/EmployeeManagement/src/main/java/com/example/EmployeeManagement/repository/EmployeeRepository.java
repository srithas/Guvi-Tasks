package com.example.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagement.domain.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
