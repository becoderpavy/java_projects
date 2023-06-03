package com.prog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prog.models.User;

@Service
public class UserService {

	List<User> list = new ArrayList<User>();

	public UserService() {
		list.add(new User("Pabitra", "abc@gmail.com", "1234"));
		list.add(new User("Pabitra2", "abc2@gmail.com", "12342"));
	}

	public List<User> getAllUser() {
		return this.list;
	}

	public User getUser(String username) {
		return this.list.stream().filter((user) -> user.getUserName().equals(username)).findAny().orElse(null);
	}
	
	public User addUser(User u)
	{
		return this.addUser(u);
	}

}
