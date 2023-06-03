package com.prog;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prog.model.Role;
import com.prog.model.User;
import com.prog.model.UserRole;
import com.prog.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner{
	
	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");
		
		
//		User u=new User();
//		u.setFirstName("Pabitra");
//		u.setLastName("Das");
//		u.setEmail("daspabitra55@gmail.com");
//		u.setPhone("7978904654");
//		u.setEnabled(true);
//		u.setProfile("default.png");
//		u.setUserName("daspabitra");
//		u.setPassword("1234");
//		
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		
//		
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(u);
//		
//		
//		Set<UserRole> userRoleSet=new HashSet<UserRole>();
//		userRoleSet.add(userRole);
//		
//		service.CreateUser(u, userRoleSet);
		
		
	}

}
