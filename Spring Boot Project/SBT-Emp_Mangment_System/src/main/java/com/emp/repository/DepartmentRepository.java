package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.enties.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
