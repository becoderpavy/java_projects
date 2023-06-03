package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Artist;
import com.entity.Category;
import com.entity.Paintings;

public class ArtistDAO {
	private Connection conn;

	public ArtistDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveArtist(Artist art) {
		boolean f = false;
		try {
			String sql = "insert into artist(full_name,shop_name,email,mobno,password,address,city,state,pincode) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, art.getFullName());
			ps.setString(2, art.getShopName());
			ps.setString(3, art.getEmail());
			ps.setString(4, art.getMobNo());
			ps.setString(5, art.getPassword());
			ps.setString(6, art.getAddress());
			ps.setString(7, art.getCity());
			ps.setString(8, art.getState());
			ps.setString(9, art.getPincode());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateArtist(Artist art) {
		boolean f = false;
		try {
			String sql = "update artist set full_name=?,shop_name=?,email=?,mobno=?,address=?,city=?,state=?,pincode=? where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, art.getFullName());
			ps.setString(2, art.getShopName());
			ps.setString(3, art.getEmail());
			ps.setString(4, art.getMobNo());
			ps.setString(5, art.getAddress());
			ps.setString(6, art.getCity());
			ps.setString(7, art.getState());
			ps.setString(8, art.getPincode());
			ps.setInt(9, art.getId());
			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Artist login(String email, String psw) {
		Artist art = null;
		try {
			String sql = "select * from artist where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				art = new Artist();
				art.setId(rs.getInt(1));
				art.setFullName(rs.getString(2));
				art.setShopName(rs.getString(3));
				art.setEmail(rs.getString(4));
				art.setMobNo(rs.getString(5));
				art.setPassword(rs.getString(6));
				art.setAddress(rs.getString(7));
				art.setCity(rs.getString(8));
				art.setState(rs.getString(9));
				art.setPincode(rs.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
	}

	public Artist getArtist(int id) {
		Artist art = null;
		try {
			String sql = "select * from artist where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				art = new Artist();
				art.setId(rs.getInt(1));
				art.setFullName(rs.getString(2));
				art.setShopName(rs.getString(3));
				art.setEmail(rs.getString(4));
				art.setMobNo(rs.getString(5));
				art.setPassword(rs.getString(6));
				art.setAddress(rs.getString(7));
				art.setCity(rs.getString(8));
				art.setState(rs.getString(9));
				art.setPincode(rs.getString(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
	}

	public boolean checkEmail(String email) {
		boolean f = true;
		try {
			String sql = "select * from artist where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean addCategory(String title, String image) {
		boolean f = true;
		try {
			String sql = "insert into category(title,image) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, image);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Category> getCategory() {
		Category cat = null;
		List<Category> list = new ArrayList<Category>();
		try {

			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean addPaintings(Paintings p) {
		boolean f = false;

		try {
			String sql = "insert into painting(name,description,price,category,image,art_id) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getCategory());
			ps.setString(5, p.getImageName());
			ps.setInt(6, p.getArt_id());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Paintings> getPaintByArtId(int artIid) {
		List<Paintings> list = new ArrayList<Paintings>();
		Paintings pain = null;
		try {
			String sql = "select * from painting where art_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artIid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
				list.add(pain);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Paintings> getPaintingForHome() {
		List<Paintings> list = new ArrayList<Paintings>();
		Paintings pain = null;
		try {
			int i=0;
			String sql = "select * from painting order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next() && i<4) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
				list.add(pain);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Paintings> getPaintingForSearch(String ch) {
		List<Paintings> list = new ArrayList<Paintings>();
		Paintings pain = null;
		try {
			int i=0;
			String sql = "select * from painting where name like ? or category like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
				list.add(pain);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	public Paintings getPaintById(int pid, int artIid) {
		Paintings pain = null;
		try {
			String sql = "select * from painting where id=? and art_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, artIid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pain;
	}

	public Paintings getPaintById(int pid) {
		Paintings pain = null;
		try {
			String sql = "select * from painting where id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pain;
	}

	public boolean updatePaintings(Paintings p) {
		boolean f = false;

		try {
			String sql = "update painting set name=?,description=?,price=?,category=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getCategory());
			ps.setInt(5, p.getId());

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deletePaintings(int pid, int artIid) {
		boolean f = false;

		try {
			String sql = "delete from painting where id=? and art_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, artIid);

			int id = ps.executeUpdate();
			if (id == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Paintings> getPaintByCategory(String sql) {
		List<Paintings> list = new ArrayList<Paintings>();
		Paintings pain = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Paintings();
				pain.setId(rs.getInt(1));
				pain.setName(rs.getString(2));
				pain.setDescription(rs.getString(3));
				pain.setPrice(rs.getString(4));
				pain.setCategory(rs.getString(5));
				pain.setImageName(rs.getString(6));
				pain.setArt_id(rs.getInt(7));
				list.add(pain);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public boolean checkOldPasssword(int id, String oldpass) {
		boolean f = false;
		try {
			String sql = "select * from artist where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, oldpass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateNewPasssword(int id, String newpass) {
		boolean f = false;
		try {
			String sql = "update artist set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setInt(2, id);
			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public int countCategories() {
		int i = 0;
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int countPaintings(int artId) {
		int i = 0;
		try {
			String sql = "select * from painting where art_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int countOrder(int artId) {
		int i = 0;
		try {
			String sql = "select * from orders where art_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public boolean checkEmailForForgot(String email) {
		boolean f = false;
		try {
			String sql = "select * from artist where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean checkEmailAndMobForForgot(String email, String mobNo) {
		boolean f = false;
		try {
			String sql = "select * from artist where email=? and mobno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, mobNo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean resetPasssword(String newpass, String email) {
		boolean f = false;
		try {
			String sql = "update artist set password=? where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newpass);
			ps.setString(2, email);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
