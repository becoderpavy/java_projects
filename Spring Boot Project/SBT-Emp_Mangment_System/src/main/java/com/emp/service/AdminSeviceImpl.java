package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.enties.Department;
import com.emp.enties.User;
import com.emp.repository.DepartmentRepository;
import com.emp.repository.UserRepository;

@Service
public class AdminSeviceImpl implements AdminService {

	@Autowired
	private UserRepository userRepo;

	

	@Autowired
	private DepartmentRepository deprtRepo;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User addEmp(User user) {
		user.setRole("ROLE_USER");
		
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllEmp() {
		return userRepo.findAll();
	}

	@Override
	public Department addDepartment(Department d) {
		return deprtRepo.save(d);
	}

	@Override
	public List<Department> getAllDepartment() {
		return deprtRepo.findAll();
	}

	@Override
	public Department getDepartmentById(long id) {
		return deprtRepo.findById(id).get();
	}

	@Override
	public boolean deleteDepartment(long id) {
		Department d = deprtRepo.findById(id).get();

		if (d != null) {
			deprtRepo.delete(d);
			return true;
		}

		return false;
	}

	@Override
	public User updateDepartmentMap(String dname, long id) {
		User us = userRepo.findById(id).get();
		us.setDepartment(dname);
		return userRepo.save(us);
	}

	@Override
	public User getEmpById(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(long id) {
		User us = userRepo.findById(id).get();
		if (us != null) {
			userRepo.delete(us);
			return true;
		}
		return false;
	}

}
