package com.prog.service;

import com.prog.entity.Student;

public interface StudentService {

	public boolean existContactNo(String contactNo);

	public boolean existEmail(String email);

	public Student registerStudent(Student user);

	public Student getUserById(int id);
	
	public Student getUserByEmail(String email);

}
