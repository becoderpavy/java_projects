package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.MedicineStore;
import com.entity.Category;
import com.entity.Medicine;

public class StoreDAO {
	private Connection conn;

	public StoreDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveArtist(MedicineStore art) {
		boolean f = false;
		try {
			String sql = "insert into stores(full_name,shop_name,email,mobno,password,address,city,state,pincode) values(?,?,?,?,?,?,?,?,?)";
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

	public boolean updateArtist(MedicineStore art) {
		boolean f = false;
		try {
			String sql = "update stores set full_name=?,shop_name=?,email=?,mobno=?,address=?,city=?,state=?,pincode=? where id=?";

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

	public MedicineStore login(String email, String psw) {
		MedicineStore art = null;
		try {
			String sql = "select * from stores where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				art = new MedicineStore();
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

	public MedicineStore getArtist(int id) {
		MedicineStore art = null;
		try {
			String sql = "select * from stores where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				art = new MedicineStore();
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
			String sql = "select * from stores where email=?";
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

	public boolean updateCategory(String title, String image, int id) {
		boolean f = true;
		try {
			String sql = "update category set title=?,image=? where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, image);
			ps.setInt(3, id);

			int a = ps.executeUpdate();
			if (a == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteCategory(int id) {
		boolean f = true;
		try {
			String sql = "delete from category where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

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

	public Category getCategoryById(int id) {
		Category cat = null;

		try {

			String sql = "select * from category where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cat;
	}

	public boolean addPaintings(Medicine p) {
		boolean f = false;

		try {
			String sql = "insert into medicine(name,description,price,category,image,store_id) values(?,?,?,?,?,?)";
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

	public List<Medicine> getPaintByArtId(int artIid) {
		List<Medicine> list = new ArrayList<Medicine>();
		Medicine pain = null;
		try {
			String sql = "select * from medicine where store_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, artIid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Medicine();
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

	public List<Medicine> getPaintingForHome() {
		List<Medicine> list = new ArrayList<Medicine>();
		Medicine pain = null;
		try {
			int i = 0;
			String sql = "select * from medicine order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next() && i < 4) {
				pain = new Medicine();
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

	public List<Medicine> getPaintingForSearch(String ch) {
		List<Medicine> list = new ArrayList<Medicine>();
		Medicine pain = null;
		try {
			int i = 0;
			String sql = "select * from medicine where name like ? or category like ? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + ch + "%");
			ps.setString(2, "%" + ch + "%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Medicine();
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

	public Medicine getPaintById(int pid, int artIid) {
		Medicine pain = null;
		try {
			String sql = "select * from medicine where id=? and store_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, artIid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Medicine();
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

	public Medicine getPaintById(int pid) {
		Medicine pain = null;
		try {
			String sql = "select * from medicine where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Medicine();
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

	public boolean updatePaintings(Medicine p) {
		boolean f = false;

		try {
			String sql = "update medicine set name=?,description=?,price=?,category=? where id=?";
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
			String sql = "delete from medicine where id=? and store_id=?";
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

	public List<Medicine> getPaintByCategory(String sql) {
		List<Medicine> list = new ArrayList<Medicine>();
		Medicine pain = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pain = new Medicine();
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
			String sql = "select * from stores where id=? and password=?";
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
			String sql = "update stores set password=? where id=?";
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
			String sql = "select * from medicine where store_id=?";
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
			String sql = "select * from orders where store_id=?";
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
			String sql = "select * from stores where email=?";
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
			String sql = "select * from stores where email=? and mobno=?";
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
			String sql = "update stores set password=? where email=?";
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
