package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.User;
import com.example.repos.UserRepo;
import com.example.utils.StorageService;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	@Autowired StorageService service;
	
	public void save(User user,MultipartFile pic){
		String filename=service.store(pic);
		user.setPhoto(filename);
		repo.save(user);
	}
	
	public List<User> listall(){
		return repo.findAll();
	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public User finduser(int id) {
		return repo.findById(id).orElse(null);
	}
}
