package com.prog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Student;
import com.prog.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public boolean existContactNo(String contactNo) {
		return studentRepo.existsByContactNo(contactNo);
	}

	@Override
	public boolean existEmail(String email) {
		return studentRepo.existsByEmail(email);
	}

	@Override
	public Student registerStudent(Student user) {
		return studentRepo.save(user);
	}

	@Override
	public Student getUserById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student getUserByEmail(String email) {
		return studentRepo.findByEmail(email);
	}

}
