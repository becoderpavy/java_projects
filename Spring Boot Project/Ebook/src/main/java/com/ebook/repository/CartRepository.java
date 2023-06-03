package com.ebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.entites.Books;
import com.ebook.entites.Cart;
import com.ebook.entites.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	public boolean existsByBookAndUser(Books book, User user);

	public List<Cart> findByUser(User user);
}
