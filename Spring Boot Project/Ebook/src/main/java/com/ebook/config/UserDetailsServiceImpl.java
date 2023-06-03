package com.ebook.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ebook.entites.User;
import com.ebook.exception.ResourceNotFoundException;
import com.ebook.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepo;

	public UserDetailsServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("user", "username=" + username, 0));

		// System.out.println(user);

		Set<SimpleGrantedAuthority> authorities = user.getRole().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());

		/*
		 * String auth =
		 * authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.
		 * joining(","));
		 * 
		 * System.out.println(authorities); System.out.println(auth);
		 */

		return CustomUserDetails.builder().user(user).id(user.getId()).userName(user.getEmail())
				.password(user.getPassword()).authorities(authorities).build();
	}

}
