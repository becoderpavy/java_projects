package com.rental.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rental.entites.User;
import com.rental.exception.ResourceNotFoundException;
import com.rental.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email" + username, 0));

		Set<SimpleGrantedAuthority> authorities = user.getRole().stream()
				.map((r) -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toSet());

		return CustomUserDetails.builder().user(user).userId(user.getId()).userName(user.getEmail())
				.password(user.getPassword()).authorities(authorities).build();
	}

}
