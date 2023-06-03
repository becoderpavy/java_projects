package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entites.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
