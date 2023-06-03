package com.portal.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String fullName;

	private String email;

	private String mobNo;

	private String password;

	private String address;

	private String city;

	private String state;

	private String pincode;

	private String experience;

	private String skill;

	private String companyName;

	@Transient
	private int roleId;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(referencedColumnName = "id", name = "user"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "role"))
	private Set<Role> role = new HashSet<Role>();

	@Transient
	private String token;

}
