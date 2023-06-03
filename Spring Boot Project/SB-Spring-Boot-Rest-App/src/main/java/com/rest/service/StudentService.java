package com.rest.service;

import java.util.List;

import com.rest.entites.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	
	public List<Student> getAllStudent();
	
	
	public Student updateStudent(long id,Student student);
	
	public String deleteStudent(long id);

}
