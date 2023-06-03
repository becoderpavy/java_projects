package com.enotes.service;

import java.util.List;

import com.enotes.entity.Notes;

public interface NotesService {
	
	public boolean saveNotes(Notes n);
	
	public List<Notes> getAllNotes();
	
	public Notes getNotesById(Long id);
	
	public boolean deleteNotes(Long id);
	
	

}
