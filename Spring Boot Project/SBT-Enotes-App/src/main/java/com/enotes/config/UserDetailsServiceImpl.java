package com.enotes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.enotes.entity.UserDtls;
import com.enotes.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDtls user = userRepo.findByEmail(username);
		//System.out.println(user);
		if (user == null) {
			//System.out.println("user Not found");
			throw new UsernameNotFoundException("User Not Exist");
		} else {
			CustomUserDetails cu = new CustomUserDetails(user);
			return cu;
		}

	}

}
