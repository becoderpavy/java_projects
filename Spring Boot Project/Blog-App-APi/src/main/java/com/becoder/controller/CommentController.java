package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.payloads.ApiResponse;
import com.becoder.payloads.CommentDto;
import com.becoder.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {
		return new ResponseEntity<>(commentService.createComment(commentDto, postId), HttpStatus.CREATED);
	}

	@DeleteMapping("/comment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
		commentService.deleteComment(id);
		return new ResponseEntity<>(new ApiResponse("Delete success", true), HttpStatus.CREATED);
	}

}
