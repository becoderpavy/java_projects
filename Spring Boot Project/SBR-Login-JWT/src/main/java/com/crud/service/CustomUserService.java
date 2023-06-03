package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crud.entites.User;
import com.crud.repo.UserRepo;

@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	

	public CustomUserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		User user=userRepo.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found exception");
		}
		
		return user;
	}

}
