package com.becoder.service;

import com.becoder.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId);

	void deleteComment(Integer id);

}
