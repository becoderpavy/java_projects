package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prog.entites.User;
import com.prog.repo.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User u = repo.getUserByUserName(email);
		
		if (u == null) {
			
			throw new UsernameNotFoundException("Could Not Found User");
		}
		CustomUserDetails cu = new CustomUserDetails(u);

		return cu;
	}

}
