package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.User;
import com.crud.exception.ResourseNotFoundException;
import com.crud.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("user not found with id:" + id));
	}
	
	@PostMapping("/save")
	public User createUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable(value = "id") long id)
	{
		User existUser=userRepository.findById(id)
		.orElseThrow(() -> new ResourseNotFoundException("user not found with id:" + id));
		
		existUser.setFirstName(user.getFirstName());
		existUser.setLastName(user.getLastName());
		existUser.setEmail(user.getEmail());
		return userRepository.save(existUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId)
	{
		User existUser=userRepository.findById(userId)
		.orElseThrow(() -> new ResourseNotFoundException("user not found with id:" + userId));
		userRepository.delete(existUser);
		return ResponseEntity.ok().build();
	}

}
