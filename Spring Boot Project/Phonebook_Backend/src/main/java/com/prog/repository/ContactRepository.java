package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Contact;
import com.prog.entites.UserDtls;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public List<Contact> findByUser(UserDtls user);

	public boolean existsByPhone(String phno);

}
