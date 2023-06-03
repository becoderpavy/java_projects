package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prog.entity.Student;
import com.prog.repository.StudentRepository;

public class CustomUserDtlsService implements UserDetailsService{
	
	@Autowired
	private StudentRepository repo;

	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
		
		try {
			
			Student u=repo.findByEmail(em);
			
			if(u==null)
			{
				throw new UsernameNotFoundException("No User");
			}else {
				return new CustomUserDtls(u);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
