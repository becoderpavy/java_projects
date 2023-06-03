package com.becoder.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.Category;
import com.becoder.entites.Post;
import com.becoder.entites.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	/*
	 * List<Post> findByUser(User user); List<Post> findByCategory(Category
	 * category);
	 */

	Page<Post> findByUser(User user, Pageable pageable);

	Page<Post> findByCategory(Category category, Pageable pageable);
	
	List<Post> findByTitleContaining(String title);

}
