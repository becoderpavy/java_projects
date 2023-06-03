package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.entity.PetDtls;
import com.entity.ShopDtls;

public class PetDAOImpl implements PetDAO {
	private Connection conn;

	public PetDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addPets(PetDtls p) {
		boolean f = false;
		try {
			String sql = "insert into pet(shop_id,category,pet_name,description,price,stock,image,status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getShopid());
			ps.setString(2, p.getCategory());
			ps.setString(3, p.getPetName());
			ps.setString(4, p.getDescription());
			ps.setDouble(5, p.getPrice());
			ps.setInt(6, p.getStock());
			ps.setString(7, p.getImage());
			ps.setString(8, p.getStatus());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<PetDtls> getPetsByShopId(int id) {
		List<PetDtls> list = new ArrayList<PetDtls>();
		PetDtls s = null;
		try {
			String sql = "select * from pet where shop_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public PetDtls getPetsById(int pid, int sid) {
		PetDtls s = null;
		try {
			String sql = "select * from pet where id=? and shop_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, sid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public PetDtls getPetsById(int pid) {
		PetDtls s = null;
		try {
			String sql = "select * from pet where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean updatePetsDetails(PetDtls p) {
		boolean f = false;
		try {
			String sql = "update pet set category=?,pet_name=?,description=?,price=?,stock=?,status=? where id=? and shop_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getCategory());
			ps.setString(2, p.getPetName());
			ps.setString(3, p.getDescription());
			ps.setDouble(4, p.getPrice());
			ps.setInt(5, p.getStock());
			ps.setString(6, p.getStatus());

			ps.setInt(7, p.getId());
			ps.setInt(8, p.getShopid());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deletePet(int pid, int sid) {
		boolean f = false;
		try {
			String sql = "delete from pet where id=? and shop_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, sid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<PetDtls> getAllPets(String sql) {
		List<PetDtls> list = new ArrayList<PetDtls>();
		PetDtls s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<PetDtls> getAllPetsByCategory(String cat) {
		List<PetDtls> list = new ArrayList<PetDtls>();
		PetDtls s = null;
		try {
			String sql = "select * from pet where category=? and status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat);
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public PetDtls getPetsByIdUSer(int pid) {
		PetDtls s = null;
		try {
			String sql = "select * from pet where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new PetDtls();
				s.setId(rs.getInt(1));
				s.setShopid(rs.getInt(2));
				s.setCategory(rs.getString(3));
				s.setPetName(rs.getString(4));
				s.setDescription(rs.getString(5));
				s.setPrice(rs.getDouble(6));
				s.setStock(rs.getInt(7));
				s.setImage(rs.getString(8));
				s.setStatus(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean deleteshop(int sid) {
		boolean f = false;
		try {
			String sql = "delete from pet where shop_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean addCategory(String categoryName) {
		boolean f = false;
		try {
			String sql = "insert into category(name) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, categoryName);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean updateCategory(String categoryName, int id) {
		boolean f = false;
		try {
			String sql = "update category set name=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, categoryName);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteCategory(int id) {
		boolean f = false;
		try {
			String sql = "delete from category where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<Category>();
		Category ca = null;
		try {
			String sql = "select * from category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ca = new Category(rs.getInt(1), rs.getString(2));
				list.add(ca);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Category getCategoryById(int id) {

		Category ca = null;
		try {
			String sql = "select * from category where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ca = new Category(rs.getInt(1), rs.getString(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ca;
	}

}
