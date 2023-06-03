package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entites.LibraryDtls;

public interface LibraryRepo extends JpaRepository<LibraryDtls, Integer> {

	public LibraryDtls findByEmail(String email);

}
