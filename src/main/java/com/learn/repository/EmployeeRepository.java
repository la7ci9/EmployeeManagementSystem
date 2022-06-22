package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
