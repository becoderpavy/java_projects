package com.prog.service;

import java.util.List;

import com.prog.entity.Collage;

public interface CollageService {

	public Collage saveCollage(Collage c);

	public List<Collage> getAllCollage();

	public Collage getCollageById(int id);

	public Collage getCollageByName(String name);

	public Collage updateCollage(Collage c,int id);

	public void deleteCollage(int id);
	
	public boolean existCollageName(String collageName);

}
