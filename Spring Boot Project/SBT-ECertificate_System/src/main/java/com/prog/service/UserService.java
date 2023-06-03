package com.prog.service;

import java.util.List;

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;
import com.prog.entites.User;

public interface UserService {

	public boolean checkEmail(String email);

	public User saveUser(User user);

	public User updateUser(User user);

	public Birth saveBirth(Birth b);

	public Marrige saveMarriage(Marrige m);

	public Death saveDeath(Death d);

	public List<Birth> getAllBirthByUserId(long uid);

	public List<Death> getAllDeathByUserId(long uid);

	public List<Marrige> getAllMarriageByUserId(long uid);

	public Marrige getMarriageById(long mid);

	public Birth getBirthById(long bid);

	public Death getDeathById(long did);
}
