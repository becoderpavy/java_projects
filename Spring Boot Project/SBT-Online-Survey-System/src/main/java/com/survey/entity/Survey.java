package com.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Data
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private String status;
	
	@Transient
	public boolean enableStatus;

}
