package com.becoder.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.becoder.payloads.ApiResponse;
import com.becoder.payloads.PostDto;
import com.becoder.service.FileService;
import com.becoder.service.PostService;
import com.becoder.utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/user/{userId}/category/{categoryId}")
	public ResponseEntity<?> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		return new ResponseEntity<>(postService.createPost(postDto, categoryId, userId), HttpStatus.CREATED);
	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<?> getPostByUserId(@PathVariable Integer userId,
			@RequestParam(value = "pageSize", defaultValue = "2", required = true) Integer pageSize,
			@RequestParam(value = "pageNo", defaultValue = "0", required = true) Integer pageNo) {
		return new ResponseEntity<>(postService.getPostByUserId(userId, pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<?> getPostByCategoryId(@PathVariable Integer categoryId,
			@RequestParam(value = "pageSize", defaultValue = "2", required = true) Integer pageSize,
			@RequestParam(value = "pageNo", defaultValue = AppConstants.PAGE_NUMBER, required = true) Integer pageNo) {
		return new ResponseEntity<>(postService.getPostByCategory(categoryId, pageNo, pageSize), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Integer id) {
		return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllPost(
			@RequestParam(value = "pageNo", defaultValue = "0", required = true) Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "2", required = true) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

		return new ResponseEntity<>(postService.getAllPost(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
		return new ResponseEntity<>(new ApiResponse("Post Delete success", true), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePost(@RequestBody PostDto postDto, @PathVariable Integer id) {
		return new ResponseEntity<>(postService.upatePost(postDto, id), HttpStatus.OK);
	}

	@GetMapping("/search/{keywords}")
	public ResponseEntity<?> searchPost(@PathVariable String keywords) {
		return new ResponseEntity<>(postService.serachPost(keywords), HttpStatus.OK);
	}

//	@PostMapping("/upload")
//	public ResponseEntity<?> uploadImage(@RequestParam("img") MultipartFile file) {
//		String fileName = null;
//		try {
//			fileName = fileService.uploadImage(path, file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return new ResponseEntity<>(new FileResponse(fileName, "some error in server"),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(new FileResponse(fileName, "upload success"), HttpStatus.OK);
//	}
//


	@PostMapping("/image/uplaod/{postId}")
	public ResponseEntity<?> uploadPostImage(@RequestParam("img") MultipartFile img, @PathVariable Integer postId)
			throws IOException {

		PostDto postDto = postService.getPostById(postId);

		String fileName = fileService.uploadImage(path, img);

		postDto.setImageName(fileName);

		return new ResponseEntity<>(postService.upatePost(postDto, postId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/file/{imgName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadFile(@PathVariable String imgName, HttpServletResponse response) throws IOException {

		InputStream resource = fileService.getResource(path, imgName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());

	}

}
