package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByEmail(String em);

	public boolean existsByEmail(String email);

	public boolean existsByContactNo(String contactNo);

}
