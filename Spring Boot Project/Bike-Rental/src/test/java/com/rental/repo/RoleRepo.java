package com.rental.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rental.entites.Role;
import com.rental.repository.RoleRepository;

@SpringBootTest
public class RoleRepo {

	@Autowired
	private RoleRepository roleRepo;

	@Test
	public void AddRole() {
		Role r = new Role(1, "ROLE_ADMIN");
		Role r2 = new Role(2, "ROLE_USER");
		roleRepo.saveAll(List.of(r, r2));
	}

}
