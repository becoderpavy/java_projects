package com.becoder.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.entites.Comment;
import com.becoder.entites.Post;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.payloads.CommentDto;
import com.becoder.repository.CommentRepository;
import com.becoder.repository.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		Comment comment = dtoToComment(commentDto);
		comment.setPost(post);
		return commentToDto(commentRepo.save(comment));
	}

	@Override
	public void deleteComment(Integer id) {

		Comment comment = commentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "id", id));

		commentRepo.delete(comment);

	}

	private Comment dtoToComment(CommentDto commentDto) {
		return modelMapper.map(commentDto, Comment.class);
	}

	private CommentDto commentToDto(Comment comment) {
		return modelMapper.map(comment, CommentDto.class);
	}

}
