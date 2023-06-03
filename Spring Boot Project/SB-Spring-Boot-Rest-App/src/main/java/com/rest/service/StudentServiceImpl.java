package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entites.Student;
import com.rest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepo.findAll();
	}

	@Override
	public Student updateStudent(long id, Student student) {
		student.setId(id);
		return studentRepo.save(student);
	}

	@Override
	public String deleteStudent(long id) {

		Optional<Student> student = studentRepo.findById(id);

		if (student.get() != null) {
			studentRepo.delete(student.get());
			return "Delete Sucessfully";
		}

		return "Student not available" + id + " id ";
	}

}
