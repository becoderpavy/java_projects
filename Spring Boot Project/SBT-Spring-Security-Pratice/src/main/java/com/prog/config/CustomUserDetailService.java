package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {

		UserDtls u = repo.findByEmail(em);

		if (u == null) {
			throw new UsernameNotFoundException("No User");
		}

		return new CustomUserDetails(u);

	}

}
