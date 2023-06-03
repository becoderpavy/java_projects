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
@Table(name = "assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "faculity_id")
	private long faculityId;

	@Column(name = "faculity_name")
	private String faculityName;

	@Column(name = "subject_name")
	private String subjectName;

	private String description;

	@Column(name = "file_name")
	private String fileName;
}
