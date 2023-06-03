package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Collage;
import com.prog.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	public List<Department> findByCollage(Collage c);
	
	public boolean existsByDepartmentName(String departmentName);

	public Department findByDepartmentName(String departmentName);
	
}
