package com.enotes.config;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enotes.entites.UserDtls;
import com.enotes.repository.UserRepository;
import com.enotes.util.SecurityUtil;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository authService;

	public CustomUserDetailsService(UserRepository authService) {
		super();
		this.authService = authService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDtls user = authService.findByUserNameOrEmail(username, username)
				.orElseThrow(() -> new UsernameNotFoundException("username or email not found with" + username));

		Set<GrantedAuthority> authorities = Set.of(SecurityUtil.convertToAuthority(user.getRole().name()));

		return CustomUserDetails.builder().user(user).id(user.getId()).userName(user.getUserName())
				.password(user.getPassword()).authorities(authorities).build();
	}

}
