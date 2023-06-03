
package com.survey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.survey.entity.UserDtls;
import com.survey.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) {

		UserDtls user = userRepo.findByEmail(username);
		if (user != null) {

			return new CustomUserDetails(user);

		} else {
			throw new UsernameNotFoundException("Username not found");
		}

	}

}
