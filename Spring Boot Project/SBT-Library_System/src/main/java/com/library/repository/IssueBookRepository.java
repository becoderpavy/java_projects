package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entites.IssueBook;
import com.library.entites.User;

public interface IssueBookRepository extends JpaRepository<IssueBook, Integer> {

	public List<IssueBook> findByUser(User user);


}
