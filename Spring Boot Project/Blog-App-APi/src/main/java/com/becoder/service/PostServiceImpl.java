package com.becoder.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.becoder.entites.Category;
import com.becoder.entites.Post;
import com.becoder.entites.User;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.payloads.PostDto;
import com.becoder.payloads.PostResponse;
import com.becoder.repository.CategoryRepo;
import com.becoder.repository.PostRepo;
import com.becoder.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

		Post post = modelMapper.map(postDto, Post.class);
		post.setImageName("default.img");
		post.setUser(user);
		post.setAddedDate(new Date());
		post.setCategory(category);

		return postToDto(postRepo.save(post));
	}

	@Override
	public PostDto upatePost(PostDto postDto, Integer id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
		post.setId(id);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());

		return postToDto(postRepo.save(post));
	}

	@Override
	public void deletePost(Integer id) {
		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
		postRepo.delete(post);

	}

	/*
	 * @Override public List<PostDto> getAllPost(Integer pageNumber,Integer
	 * pageSize) {
	 * 
	 * Pageable pageable=PageRequest.of(pageNumber, pageSize);
	 * 
	 * Page<Post> pagePost=postRepo.findAll(pageable); List<Post>
	 * postList=pagePost.getContent();
	 * 
	 * //return postRepo.findAll().stream().map((post) ->
	 * postToDto(post)).collect(Collectors.toList());
	 * 
	 * return postList.stream().map((post) ->
	 * postToDto(post)).collect(Collectors.toList()); }
	 */

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		/*
		 * Sort sort = null; if (sortDir.equalsIgnoreCase("asc")) { sort =
		 * Sort.by(sortBy).ascending(); } else { sort = Sort.by(sortBy).descending(); }
		 */

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Post> pagePost = postRepo.findAll(pageable);

		List<Post> postList = pagePost.getContent();

		List<PostDto> postDto = postList.stream().map((post) -> postToDto(post)).collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());

		postResponse.setLastPage(pagePost.isLast());

		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer id) {

		Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));

		return postToDto(post);
	}

	@Override
	public List<PostDto> serachPost(String keyword) {
		return postRepo.findByTitleContaining(keyword).stream().map(post -> postToDto(post))
				.collect(Collectors.toList());
	}

	/*
	 * @Override public List<PostDto> getPostByCategory(Integer categoryId) {
	 * Category cat = categoryRepo.findById(categoryId) .orElseThrow(() -> new
	 * ResourceNotFoundException("category", "id", categoryId)); return
	 * postRepo.findByCategory(cat).stream().map((post) ->
	 * postToDto(post)).collect(Collectors.toList()); }
	 */

	@Override
	public PostResponse getPostByCategory(Integer categoryId, Integer pageNo, Integer pageSize) {

		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Post> pagePost = postRepo.findByCategory(cat, pageable);

		List<PostDto> postDto = pagePost.getContent().stream().map((post) -> postToDto(post))
				.collect(Collectors.toList());

		PostResponse postResponse = new PostResponse(postDto, pagePost.getNumber(), pagePost.getSize(),
				pagePost.getTotalElements(), pagePost.getTotalPages(), pagePost.isLast());

		return postResponse;
	}

	/*
	 * @Override public List<PostDto> getPostByUserId(Integer userId) { User user =
	 * userRepo.findById(userId).orElseThrow(() -> new
	 * ResourceNotFoundException("user", "id", userId));
	 * 
	 * return postRepo.findByUser(user).stream().map((post) ->
	 * postToDto(post)).collect(Collectors.toList()); }
	 */

	@Override
	public PostResponse getPostByUserId(Integer userId, Integer pageNo, Integer pageSize) {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Post> pagePost = postRepo.findByUser(user, pageable);

		List<Post> postList = pagePost.getContent();

		List<PostDto> postDto = postList.stream().map((post) -> postToDto(post)).collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();

		postResponse.setContent(postDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());

		return postResponse;
	}

	private Post dtoToPost(PostDto postDto) {
		return modelMapper.map(postDto, Post.class);
	}

	private PostDto postToDto(Post post) {
		return modelMapper.map(post, PostDto.class);
	}

}
