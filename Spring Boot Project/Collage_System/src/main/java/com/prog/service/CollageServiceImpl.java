package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Collage;
import com.prog.exception.ResourceNotFoundException;
import com.prog.repository.CollageRepo;

@Service
public class CollageServiceImpl implements CollageService {

	@Autowired
	private CollageRepo collageRepo;

	@Override
	public Collage saveCollage(Collage c) {
		return collageRepo.save(c);
	}

	@Override
	public List<Collage> getAllCollage() {

		return collageRepo.findAll();
	}

	@Override
	public Collage getCollageById(int id) {
		return collageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Collage", "id", id));
	}

	@Override
	public Collage getCollageByName(String name) {
		return collageRepo.findByCollageName(name);
	}

	@Override
	public Collage updateCollage(Collage c, int id) {
		Collage oldCollage = collageRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Collage", "id", id));

		oldCollage.setCollageName(c.getCollageName());
		oldCollage.setAddress(c.getAddress());
		oldCollage.setCity(c.getCity());
		oldCollage.setState(c.getState());
		oldCollage.setPincode(c.getPincode());

		return collageRepo.save(oldCollage);
	}

	@Override
	public void deleteCollage(int id) {

		Collage c = collageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Collage", "id", id));

		if (c != null) {
			collageRepo.delete(c);
		}
	}

	@Override
	public boolean existCollageName(String collageName) {
		return collageRepo.existsByCollageName(collageName);
	}

}
