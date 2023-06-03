package com.emp.service;

import java.util.List;

import com.emp.enties.Department;
import com.emp.enties.User;

public interface AdminService {

	public boolean checkEmail(String email);

	public User addEmp(User e);

	public List<User> getAllEmp();

	public User getEmpById(long id);

	public boolean deleteEmp(long id);

	public Department addDepartment(Department d);

	public List<Department> getAllDepartment();

	public Department getDepartmentById(long id);

	public boolean deleteDepartment(long id);

	public User updateDepartmentMap(String dname, long id);

}
