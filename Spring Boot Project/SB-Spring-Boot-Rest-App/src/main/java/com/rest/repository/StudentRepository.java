package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entites.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
