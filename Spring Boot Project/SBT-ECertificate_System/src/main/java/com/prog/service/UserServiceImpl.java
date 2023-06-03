package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;
import com.prog.entites.User;
import com.prog.repository.BirthRepository;
import com.prog.repository.DeathRepository;
import com.prog.repository.MarriageRepository;
import com.prog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Autowired
	private BirthRepository birthRepo;

	@Autowired
	private DeathRepository deathRepo;

	@Autowired
	private MarriageRepository marrRepo;

	@Autowired
	public UserRepository userRepo;

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		User oldUser = userRepo.findById(user.getId()).get();
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());
		return userRepo.save(user);
	}

	@Override
	public Birth saveBirth(Birth b) {
		return birthRepo.save(b);
	}

	@Override
	public Marrige saveMarriage(Marrige m) {
		return marrRepo.save(m);
	}

	@Override
	public Death saveDeath(Death d) {
		return deathRepo.save(d);
	}

	@Override
	public List<Birth> getAllBirthByUserId(long uid) {
		return birthRepo.findByUserId(uid);
	}

	@Override
	public Birth getBirthById(long bid) {
		return birthRepo.findById(bid).get();
	}

	@Override
	public List<Death> getAllDeathByUserId(long uid) {
		return deathRepo.findByUserId(uid);
	}

	@Override
	public Death getDeathById(long did) {
		return deathRepo.findById(did).get();
	}

	@Override
	public List<Marrige> getAllMarriageByUserId(long uid) {
		return marrRepo.findByUserId(uid);
	}

	@Override
	public Marrige getMarriageById(long mid) {
		return marrRepo.findById(mid).get();
	}

}
