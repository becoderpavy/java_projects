package com.emp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emp.enties.User;
import com.emp.repository.UserRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRpo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User e = userRpo.findByEmail(username);

		if (e == null) {
			throw new UsernameNotFoundException("User Not Exist");
		} else {

			return new CustomUserDetails(e);
		}

	}

}
