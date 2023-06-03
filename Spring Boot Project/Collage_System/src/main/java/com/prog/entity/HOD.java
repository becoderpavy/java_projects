package com.prog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HOD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String hodName;

	@ManyToOne
	private Collage collage;

	@OneToOne
	private Department department;

}
