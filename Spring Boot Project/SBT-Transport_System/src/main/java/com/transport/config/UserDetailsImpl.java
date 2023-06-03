package com.transport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.transport.entites.User;
import com.transport.repository.UserRepo;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User Not Exist");
		} else {

			return new CustomUserDetails(user);
		}

	}

}
