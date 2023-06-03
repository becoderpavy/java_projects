package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prog.entites.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT m FROM Book m WHERE m.bookName LIKE %:bookName% OR m.author LIKE %:author% OR m.category LIKE %:category%")
	List<Book> findByBookNameSearch(String bookName, String author, String category);

}
