package com.enotes.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.enotes.entites.Notes;
import com.enotes.exception.NotesApiException;
import com.enotes.exception.ResourceNotFoundException;
import com.enotes.jwt.JwtProvider;
import com.enotes.repository.NotesRepository;
import com.enotes.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class NoteServiceImpl implements NotesService {

	@Autowired
	private NotesRepository noteRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JwtProvider JwtProvider;

	public int getUserId(HttpServletRequest request) {
		Claims claim = JwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);
		return userId;
	}

	@Override
	public Notes addNotes(Notes note, HttpServletRequest request) {

		int userId = getUserId(request);
		note.setCreateTime(LocalDateTime.now());
		note.setUserId(userId);
		System.out.println(userId);
		userRepo.findById(note.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "Userid", note.getUserId()));

		return noteRepo.save(note);
	}

	@Override
	public Notes updateNotes(int id, Notes n, HttpServletRequest request) {
		Notes oldNotes = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "Id", id));

		Integer userId = getUserId(request);
		if (!userId.equals(oldNotes.getUserId())) {
			throw new NotesApiException(HttpStatus.BAD_REQUEST, "invalid user");
		}

		n.setCreateTime(oldNotes.getCreateTime());
		n.setId(id);
		n.setUserId(oldNotes.getUserId());
		return noteRepo.save(n);
	}

	@Override
	public void deleteNotes(int id) {
		Notes n = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("notes", "id", id));
		noteRepo.delete(n);
	}

	@Override
	public List<Notes> getAllNotes(HttpServletRequest request) {

		int userId = getUserId(request);

		return noteRepo.findByUserId(userId);
	}

	@Override
	public Notes getNotesById(int id, HttpServletRequest request) {

		Integer userId = getUserId(request);
		Notes n = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("notes", "id", id));

		if (!userId.equals(n.getUserId())) {
			throw new NotesApiException(HttpStatus.BAD_REQUEST, "UnAuthorized User Access");
		}

		return n;
	}

}
