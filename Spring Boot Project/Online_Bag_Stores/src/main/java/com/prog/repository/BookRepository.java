package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prog.entites.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT s FROM Book s ORDER BY s.id DESC")
	List<Book> findOrderByIddesc();

	List<Book> findByCategortId(int id);

	@Query("SELECT m FROM Book m WHERE m.bookName LIKE %:bookName%")
	List<Book> findByBookNameSearch(String bookName);

}
