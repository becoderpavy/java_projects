package com.prog.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.model.User;
import com.prog.model.UserRole;
import com.prog.repo.RoleRepository;
import com.prog.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository role;

	@Override
	public User CreateUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepo.findByUserName(user.getUserName());
		
		
			if (local != null) {
				System.out.println("User Already There !!");
				throw new Exception("User already Present");
			} else {
				
				for (UserRole ur : userRoles) {
					role.save(ur.getRole());
				}

				user.getUserRoles().addAll(userRoles);
				local = userRepo.save(user);

			}
		return local;
	}

	@Override
	public User getUser() {
		
		return null;
	}
	
	
	
	

}
