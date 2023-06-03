package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prog.models.User;
import com.prog.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u=this.repo.findByUserName(username);
		
		if(u==null)
		{
			System.out.println("2");
			throw new UsernameNotFoundException("NO USER");
		}
		System.out.println(u);
		return new CustomUserDetails(u);
	}

}
