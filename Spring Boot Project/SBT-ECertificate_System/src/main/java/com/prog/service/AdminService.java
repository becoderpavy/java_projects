package com.prog.service;

import java.util.List;

import com.prog.entites.Birth;
import com.prog.entites.Death;
import com.prog.entites.Marrige;

public interface AdminService {

	public List<Birth> getAllBirth();

	public List<Marrige> getAllMarriage();

	public List<Death> getAllDeath();

	public Marrige getMarriageById(long mid);

	public Birth getBirthById(long bid);

	public Death getDeathById(long did);
	
	public Birth saveBirth(Birth b);

	public Marrige saveMarriage(Marrige m);

	public Death saveDeath(Death d);

}
