package com.enotes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "USER_DTLS")
@Data
@ToString
public class UserDtls extends Audit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String about;
	private String role;

	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy =
	 * "UserDtls" )
	 * private List<Notes> notes;
	 */
	


	
	
	
	

}
