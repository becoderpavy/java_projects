package com.prog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.prog.entity.Gender;
import com.prog.entity.Student;
import com.prog.repository.StudentRepository;
import com.prog.service.StudentService;

@SpringBootTest
class StudentRegistrationAppApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void existContactTest() {
		String contactNo = "123456789";
		
		Student student = new Student(121, "Abhishek", "", "Kumar", "BTECH", Gender.MALE, "123456789", "India",
				"Student@gmail.com", "1234", "STUDENT");
		
		when(studentRepository.existsByContactNo(student.getContactNo())).thenReturn(true);
		
		assertEquals(true, studentService.existContactNo(contactNo));
	}

	@Test
	public void existEmailTest() {
		String email = "Student@gmail.com";
		Student student = new Student(121, "Abhishek", "", "Kumar", "BTECH", Gender.MALE, "123456789", "India",
				"Student@gmail.com", "1234", "STUDENT");
		
		when(studentRepository.existsByEmail(student.getEmail())).thenReturn(true);
		
		assertEquals(true, studentService.existEmail(email));
	}

	@Test
	public void saveStudentTest() {
		Student student = new Student(121, "Abhishek", "", "Kumar", "BTECH", Gender.MALE, "123456789", "India",
				"Student@gmail.com", "1234", "STUDENT");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentService.registerStudent(student));

	}

	@Test
	public void getUserByIdTest() {
		int id = 121;
		Student student = new Student(121, "Abhishek", "", "Kumar", "BTECH", Gender.MALE, "123456789", "India",
				"Student@gmail.com", "1234", "STUDENT");
		when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));

		assertEquals(student, studentService.getUserById(id));

	}

	@Test
	public void getUserByEmailTest() {
		String email = "Student@gmail.com";
		Student student = new Student(121, "Abhishek", "", "Kumar", "BTECH", Gender.MALE, "123456789", "India",
				"Student@gmail.com", "1234", "STUDENT");
		when(studentRepository.findByEmail(student.getEmail())).thenReturn(student);

		assertEquals(student, studentService.getUserByEmail(email));
	}

}
