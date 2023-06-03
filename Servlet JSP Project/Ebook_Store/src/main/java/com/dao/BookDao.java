package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book;

public class BookDao {
	private Connection conn;

	public BookDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addBook(Book b) {
		boolean f = false;
		try {
			String sql = "insert into book(book_name,author,department,image_name,pdf_name,status,description) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDepartment());
			ps.setString(4, b.getImageName());
			ps.setString(5, b.getPdfName());
			ps.setString(6, b.getStatus());
			ps.setString(7, b.getDescription());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Book> getAllBook() {
		List<Book> list = new ArrayList<Book>();
		Book b = null;

		try {
			String sql = "select * from book order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Book> getBookByStatus() {
		List<Book> list = new ArrayList<Book>();
		Book b = null;

		try {
			String sql = "select * from book where status=? and department=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2,"Business administartion");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Book> getBookByStatusIT() {
		List<Book> list = new ArrayList<Book>();
		Book b = null;

		try {
			String sql = "select * from book where status=? and department=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2, "IT");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Book> getBookByStatusMedical() {
		List<Book> list = new ArrayList<Book>();
		Book b = null;

		try {
			String sql = "select * from book where status=? and department=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2,"Medical");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	public List<Book> getBookByRecommend() {
		List<Book> list = new ArrayList<Book>();
		Book b = null;
		int i = 0;
		try {
			String sql = "select * from book where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i<4) {
				i++;
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book getBookById(int id) {
		Book b = null;
		try {
			String sql = "select * from book where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean updateBook(Book b) {
		boolean f = false;
		try {
			String sql = "update book set book_name=?,author=?,department=?,status=?,description=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDepartment());
			ps.setString(4, b.getStatus());
			ps.setString(5, b.getDescription());
			ps.setInt(6, b.getId());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateBookWithImg(Book b) {
		boolean f = false;
		try {
			String sql = "update book set book_name=?,author=?,department=?,image_name=?,status=?,description=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDepartment());
			ps.setString(4, b.getImageName());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getDescription());
			ps.setInt(7, b.getId());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateBookWithPdf(Book b) {
		boolean f = false;
		try {
			String sql = "update book set book_name=?,author=?,department=?,pdf_name=?,status=?,description=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDepartment());
			ps.setString(4, b.getPdfName());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getDescription());
			ps.setInt(7, b.getId());
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateBookWithPdfAndImg(Book b) {
		boolean f = false;
		try {
			String sql = "update book set book_name=?,author=?,department=?,image_name=?,pdf_name=?,status=?,description=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getDepartment());
			ps.setString(4, b.getImageName());
			ps.setString(5, b.getPdfName());
			ps.setString(6, b.getStatus());
			ps.setString(7, b.getDescription());
			ps.setInt(8, b.getId());
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
			String sql = "delete from book where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public List<Book> getBookBySerch(String ch) {

		List<Book> list = new ArrayList<Book>();
		Book b = null;
		try {

			String sql = "select * from book where book_name like ? or author like ? or department like ? and status=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setDepartment(rs.getString(4));
				b.setImageName(rs.getString(5));
				b.setPdfName(rs.getString(6));
				b.setStatus(rs.getString(7));
				b.setDescription(rs.getString(8));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
