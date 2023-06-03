package com.prog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prog.entites.Role;
import com.prog.repository.RoleRepository;
import com.prog.util.AppConstant;

@SpringBootApplication
public class FoodOrderingBackendApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderingBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		com.prog.entites.Role r = new Role();
		r.setId(AppConstant.ADMIN_ID);
		r.setRole("ROLE_ADMIN");

		Role r2 = new Role();
		r2.setId(AppConstant.USER_ID);
		r2.setRole("ROLE_USER");

		List<Role> of = List.of(r, r2);
		roleRepo.saveAll(of);
	}

}
