package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prog.entites.Emp;
import com.prog.repository.EmpRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private EmpRepository empRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Emp e = empRepo.findByEmail(username);

		if (e == null) {
			throw new UsernameNotFoundException("User Not Exist");
		} else {

			return new CustomUserDetails(e);
		}

	}

}
