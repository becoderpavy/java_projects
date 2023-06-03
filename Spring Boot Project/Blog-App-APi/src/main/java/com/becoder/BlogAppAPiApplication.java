package com.becoder;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.becoder.entites.Role;
import com.becoder.repository.RoleRepository;

@SpringBootApplication
public class BlogAppAPiApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppAPiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setId(101);
		role.setName("ROLE_ADMIN");
		Role role2 = new Role();
		role2.setId(102);
		role2.setName("ROLE_USER");

		List<Role> roles = List.of(role, role2);
		roleRepo.saveAll(roles);

	}

}
