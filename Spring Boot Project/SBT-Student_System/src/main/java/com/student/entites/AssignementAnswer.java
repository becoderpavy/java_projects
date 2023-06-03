package com.student.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "assignment_answer")
public class AssignementAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "assignment_id")
	private long assignmentId;

	@Column(name = "faculity_id")
	private long faculityId;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "file_name")
	private String fileName;
	
	private String grade;

	private String remark;

}
