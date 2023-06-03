package com.banking.config;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banking.entity.UserDtls;
import com.banking.exception.ResourceNotFoundException;
import com.banking.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepo;

	public UserDetailsServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDtls user = userRepo.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("user", "username=" + username, 0));

		SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole());

		return CustomUserDetails.builder().user(user).id(user.getId()).userName(user.getEmail())
				.password(user.getPassword()).authorities(Arrays.asList(authorities)).build();
	}

}
