package com.prog.service;

import java.util.List;

import com.prog.entity.Department;
import com.prog.model.DepartmentRequest;

public interface DepartmentService {

	public String saveDepartment(DepartmentRequest dep);
	
	public List<Department> getDepartmentByCollageName(String name);
	
	public boolean existDepartment(String departmentName);
	
}
