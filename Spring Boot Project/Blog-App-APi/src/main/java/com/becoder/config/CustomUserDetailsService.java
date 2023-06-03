package com.becoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.becoder.entites.User;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("security service");
		User user = userRep.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("user", "username=" + username, 0));

		return user;
	}

}
