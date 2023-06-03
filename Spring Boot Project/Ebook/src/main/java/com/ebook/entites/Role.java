package com.ebook.entites;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {

	@Id
	private Integer id;
	
	private String role;
	
	
	
}
