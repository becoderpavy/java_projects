package com.ebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.entites.BookOrder;
import com.ebook.entites.User;

public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {

	public List<BookOrder> findByUser(User user);

}
