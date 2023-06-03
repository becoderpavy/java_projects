package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;
import com.prog.repository.BirthRepository;
import com.prog.repository.DeathRepository;
import com.prog.repository.MarriageRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private BirthRepository birthRepo;

	@Autowired
	private DeathRepository deathRepo;

	@Autowired
	private MarriageRepository marrRepo;

	@Override
	public List<Birth> getAllBirth() {
		return birthRepo.findAll();
	}

	@Override
	public List<Marrige> getAllMarriage() {
		return marrRepo.findAll();
	}

	@Override
	public List<Death> getAllDeath() {
		return deathRepo.findAll();
	}

	@Override
	public Marrige getMarriageById(long mid) {
		return marrRepo.findById(mid).get();
	}

	@Override
	public Birth getBirthById(long bid) {
		return birthRepo.findById(bid).get();
	}

	@Override
	public Death getDeathById(long did) {
		return deathRepo.findById(did).get();
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

}
