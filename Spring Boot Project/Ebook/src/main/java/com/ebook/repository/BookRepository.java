package com.ebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebook.entites.*;

public interface BookRepository extends JpaRepository<Books, Integer> {

	@Query("SELECT m FROM Books m WHERE m.bookName LIKE %:ch% or m.author LIKE %:ch% or m.isbnNo LIKE %:ch% ")
	public List<Books> search(String ch);

}
