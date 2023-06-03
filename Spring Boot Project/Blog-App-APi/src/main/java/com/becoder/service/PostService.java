package com.becoder.service;

import java.util.List;

import com.becoder.payloads.PostDto;
import com.becoder.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);

	PostDto upatePost(PostDto postDto, Integer id);

	void deletePost(Integer id);

	// List<PostDto> getAllPost(Integer pageNumber,Integer pageSize);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

	PostDto getPostById(Integer id);

	List<PostDto> serachPost(String keyword);

	//List<PostDto> getPostByCategory(Integer categoryId);
	
	PostResponse getPostByCategory(Integer categoryId,Integer pageNo,Integer pageSize);

	//List<PostDto> getPostByUserId(Integer userId);
	
	PostResponse getPostByUserId(Integer userId,Integer pageNo,Integer pageSize);

}
