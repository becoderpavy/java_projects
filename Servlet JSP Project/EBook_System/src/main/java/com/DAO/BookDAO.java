package com.DAO;

import java.util.List;

import com.entity.bookDtls;

public interface BookDAO {
	
	public boolean AddAdminBook(bookDtls book);
	
	public List<bookDtls> getRecentBook();
	
	public List<bookDtls> getRecentAllBook();
	
	public List<bookDtls> getNewBook();
	
	public List<bookDtls> getNewAllBook();
	
	public List<bookDtls> getOldBook();
	
	public List<bookDtls> getOldAllBook();
	
	public List<bookDtls> getAllBook();

	public bookDtls getBookById(int id);
	
	public boolean editBookUpdate(bookDtls book);
	
	public boolean deleteBook(int id);
	
	public List<bookDtls> getBookBySearch(String ch);
	
}
