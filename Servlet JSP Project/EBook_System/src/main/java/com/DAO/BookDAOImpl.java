package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.bookDtls;

public class BookDAOImpl implements BookDAO {

	private Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	/* Add book by Admin */
	public boolean AddAdminBook(bookDtls book) {
		boolean f = false;
		try {
			String sql = "insert into book(bookname,author,price,bookCategory,status,photo,user_email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getCategories());
			ps.setString(5, book.getBookStatus());
			ps.setString(6, book.getBookImg());
			ps.setString(7, book.getUserEmail());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	/* Get Recent Book Display in index Page */

	public List<bookDtls> getRecentBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		int i = 0;
		try {
			String sql = "select * from book where status=? order by bookId DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i < 4) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	// get all recent book in recent_book.jsp
	public List<bookDtls> getRecentAllBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;

		try {
			String sql = "select * from book where status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	/* Get new Book Display in index Page */

	public List<bookDtls> getNewBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		int i = 0;
		try {
			String sql = "select * from book where  bookCategory=? and status=? order by bookId DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i < 4) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	/* get all new book in new_book.jsp */
	public List<bookDtls> getNewAllBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		try {
			String sql = "select * from book where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	/* Get new Book Display in index Page */

	public List<bookDtls> getOldBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		int i = 0;
		try {
			String sql = "select * from book where  bookCategory=? and status=? order by bookId DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i < 4) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	/* get all old book in old_book.jsp */
	public List<bookDtls> getOldAllBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		try {
			String sql = "select * from book where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	/* get all book display in admin panel view */
	public List<bookDtls> getAllBook() {
		List<bookDtls> bookList = new ArrayList<bookDtls>();
		bookDtls book = null;
		try {
			String sql = "select * from book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public bookDtls getBookById(int id) {
		bookDtls book = null;
		try {
			String sql = "select * from book where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new bookDtls();
				book.setId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthorName(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setCategories(rs.getString(5));
				book.setBookStatus(rs.getString(6));
				book.setBookImg(rs.getString(7));
				book.setUserEmail(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public boolean editBookUpdate(bookDtls book) {

		boolean f = false;
		try {
			String sql = "update book set bookname=?,author=?,price=?,bookCategory=?,status=? where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getAuthorName());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getCategories());
			ps.setString(5, book.getBookStatus());
			ps.setInt(6, book.getId());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public boolean deleteBook(int id) {
		boolean f = false;
		try {
			String sql = "delete from book where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<bookDtls> getBookBySearch(String ch) {
		List<bookDtls> list = new ArrayList<bookDtls>();
		bookDtls b = null;
		String sql = "select * from book where bookname like ? or bookCategory like ? or author like ? and status=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");
			ps.setString(3, "%" + ch + "%");
			ps.setString(4, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new bookDtls();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setPrice(rs.getInt(4));
				b.setCategories(rs.getString(5));
				b.setBookStatus(rs.getString(6));
				b.setBookImg(rs.getString(7));
				b.setUserEmail(rs.getString(8));
				list.add(b);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
