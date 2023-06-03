package com.library.service;

import java.util.List;

import com.library.entites.IssueBook;
import com.library.entites.LibraryDtls;

public interface LibraryService {

	public LibraryDtls saveLibrary(LibraryDtls lib);

	public List<LibraryDtls> getAllLibrary();

	public LibraryDtls getLibById(int id);

	public boolean deleteLibrary(int id);

	public IssueBook appyIssueBook(IssueBook book);

}
