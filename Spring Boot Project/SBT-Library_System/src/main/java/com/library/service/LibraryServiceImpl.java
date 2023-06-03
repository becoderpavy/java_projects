package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entites.IssueBook;
import com.library.entites.LibraryDtls;
import com.library.repository.IssueBookRepository;
import com.library.repository.LibraryRepo;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepo libRepo;

	@Autowired
	private IssueBookRepository issueBookRepo;

	@Override
	public LibraryDtls saveLibrary(LibraryDtls lib) {
		return libRepo.save(lib);
	}

	@Override
	public List<LibraryDtls> getAllLibrary() {
		return libRepo.findAll();
	}

	@Override
	public LibraryDtls getLibById(int id) {
		return libRepo.findById(id).get();
	}

	@Override
	public boolean deleteLibrary(int id) {
		LibraryDtls lib = libRepo.findById(id).get();
		if (lib != null) {
			libRepo.delete(lib);
			return true;
		}
		return false;
	}

	@Override
	public IssueBook appyIssueBook(IssueBook book) {
		return issueBookRepo.save(book);
	}

}
