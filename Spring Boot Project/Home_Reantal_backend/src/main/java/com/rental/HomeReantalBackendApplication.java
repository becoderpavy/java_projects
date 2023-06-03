package com.rental;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rental.entites.Role;
import com.rental.repository.RoleRepository;
import com.rental.util.AppConstant;

@SpringBootApplication
public class HomeReantalBackendApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(HomeReantalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role r = new Role();
		r.setId(AppConstant.ADMIN_ID);
		r.setRole("ROLE_ADMIN");

		Role r2 = new Role();
		r2.setId(AppConstant.USER_ID);
		r2.setRole("ROLE_BUYER");

		Role r3 = new Role();
		r3.setId(AppConstant.SELLER_ID);
		r3.setRole("ROLE_SELLER");

		List<Role> of = List.of(r, r2,r3);
		roleRepo.saveAll(of);
	}

}
