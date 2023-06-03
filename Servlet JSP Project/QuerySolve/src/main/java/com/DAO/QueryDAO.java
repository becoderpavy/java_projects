package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Answer;
import com.entity.Query;

public class QueryDAO {

	private Connection conn;

	public QueryDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddQueries(String query, String categories, String username, String postDate, String descr,
			String filename) {
		boolean f = false;
		try {
			String qu = "insert into query(question,categories,username,postDate,description,img) values(?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, query);
			ps.setString(2, categories);
			ps.setString(3, username);
			ps.setString(4, postDate);
			ps.setString(5, descr);
			ps.setString(6, filename);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean addAnswer(int qid, String ans, String pdate, String userName) {
		boolean f = false;
		try {
			String sql = "insert into answer(username,question_id,answer,post_date) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, qid);
			ps.setString(3, ans);
			ps.setString(4, pdate);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Query> getQueries() {
		List<Query> list = new ArrayList<Query>();
		Query qu = null;
		try {

			String sql = "select * from query order by id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qu = new Query();
				qu.setId(rs.getInt(1));
				qu.setQuestion(rs.getString(2));
				qu.setCategories(rs.getString(3));
				qu.setUsername(rs.getString(4));
				qu.setPostDate(rs.getString(5));
				qu.setDescription(rs.getString(6));
				qu.setImg(rs.getString(7));
				list.add(qu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Query getQueryById(int id) {
		Query qu = null;
		try {
			String sql = "select * from query where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qu = new Query();
				qu.setId(rs.getInt(1));
				qu.setQuestion(rs.getString(2));
				qu.setCategories(rs.getString(3));
				qu.setUsername(rs.getString(4));
				qu.setPostDate(rs.getString(5));
				qu.setDescription(rs.getString(6));
				qu.setImg(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}

	public List<Answer> getAnswerById(int qid) {
		List<Answer> list = new ArrayList<Answer>();
		Answer qu = null;
		try {
			String sql = "select * from answer where question_id=? order by id DESC";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, qid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qu = new Answer();
				qu.setId(rs.getInt(1));
				qu.setUserName(rs.getString(2));
				qu.setQuestion_id(rs.getInt(3));
				qu.setAnswer(rs.getString(4));
				qu.setPost_date(rs.getString(5));
				list.add(qu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Query> getQueriesByCategory(String cat) {
		List<Query> list = new ArrayList<Query>();
		Query qu = null;
		try {
			String sql = "select * from query where categories=? order by id DESC";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qu = new Query();
				qu.setId(rs.getInt(1));
				qu.setQuestion(rs.getString(2));
				qu.setCategories(rs.getString(3));
				qu.setUsername(rs.getString(4));
				qu.setPostDate(rs.getString(5));
				qu.setDescription(rs.getString(6));
				qu.setImg(rs.getString(7));
				list.add(qu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
