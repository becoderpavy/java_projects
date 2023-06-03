package com.contact.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.contact.model.Contact;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class ContactDaoImpl implements ContactDao {

	private JdbcTemplate jdbcTemplate;

	public ContactDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int save(Contact c) {
		String sql = "insert into contact(name,email,address,phone) values(?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone());

		return i;
	}

	public int update(Contact c) {
		String sql = "update contact set name=? , email=?,address=?,phone=? where id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getAddress(), c.getPhone(), c.getId());
	}

	public Contact get(Integer id) {

		String sql = "select * from contact where id=?";

		ResultSetExtractor<Contact> ext = new ResultSetExtractor<Contact>() {

			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					return new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
				}

				return null;
			}

		};

		return jdbcTemplate.query(sql, ext);
	}

	public int delete(Integer id) {
		String sql = "delete from contact where id=?";

		return jdbcTemplate.update(sql, id);
	}

	public List<Contact> list() {
		String sql = "select * from contact";

		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
