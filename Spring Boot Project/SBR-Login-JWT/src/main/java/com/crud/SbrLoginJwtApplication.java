package com.crud;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.crud.entites.Authority;
import com.crud.entites.User;
import com.crud.repo.UserRepo;
import com.crud.service.CustomUserService;

@SpringBootApplication
public class SbrLoginJwtApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(SbrLoginJwtApplication.class, args);
	}
	
	
	@PostConstruct
	protected void init() {
		List<Authority> authoritiesList=new ArrayList<Authority>();
		authoritiesList.add(createAuthority("USER","User role"));
		authoritiesList.add(createAuthority("ADMIN","Admin role"));
		
		
		User user=new User();
		user.setUserName("pabitra");
		user.setFirstName("Pabitra");
		user.setLastName("Das");
		
		user.setPassword(passwordEncoder.encode("1234"));
		user.setEnabled(true);
		user.setAuthorites(authoritiesList);
		repo.save(user);
		
	}


	private Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
