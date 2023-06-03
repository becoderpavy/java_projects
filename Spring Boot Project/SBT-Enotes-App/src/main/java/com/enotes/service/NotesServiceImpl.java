package com.enotes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enotes.entity.Notes;
import com.enotes.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository noteRepo;

	@Override
	public boolean saveNotes(Notes n) {
		Notes notes = noteRepo.save(n);
		return notes.getId() != null;
	}

	@Override
	public List<Notes> getAllNotes() {
		return noteRepo.findAll();
	}

	@Override
	public Notes getNotesById(Long id) {

		Optional<Notes> notes = noteRepo.findById(id);
		if (notes != null) {
			notes.get();
		}
		return null;
	}

	@Override
	public boolean deleteNotes(Long id) {
		noteRepo.deleteById(id);
		return true;
	}

}
