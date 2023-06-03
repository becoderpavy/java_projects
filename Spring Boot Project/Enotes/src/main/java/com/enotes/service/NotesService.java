package com.enotes.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.enotes.entites.Notes;

public interface NotesService {

	public Notes addNotes(Notes note, HttpServletRequest request);

	public void deleteNotes(int id);

	public List<Notes> getAllNotes(HttpServletRequest request);

	public Notes updateNotes(int id, Notes n,HttpServletRequest request);

	public Notes getNotesById(int id,HttpServletRequest request);
	
}
