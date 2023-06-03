package com.prog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prog.models.User;
import com.prog.repo.UserRepo;

@SpringBootApplication
public class SbtSpringSecurityTutorialApplication implements CommandLineRunner {

	@Autowired
	private UserRepo repo;

	@Autowired
	private BCryptPasswordEncoder bp;

	@Override
	public void run(String... args) throws Exception {
		User u = new User();
		u.setUserName("Pabitra3");
		u.setEmail("abc@gmail.com2");
		u.setPassword(this.bp.encode("1234"));
		u.setRole("ROLE_ADMIN");
		repo.save(u);

	}

	public static void main(String[] args) {
		SpringApplication.run(SbtSpringSecurityTutorialApplication.class, args);
	}

}
