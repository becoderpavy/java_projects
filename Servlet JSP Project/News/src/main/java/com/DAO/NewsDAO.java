package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Comment;
import com.entity.News;

public class NewsDAO {
	private Connection conn;

	public NewsDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveNews(News n) {
		boolean f = false;
		try {

			String sql = "insert into newsAdd(title,description,username) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			System.out.print(n.getTitle() + " " + n.getDescription() + " " + n.getUserName());
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getDescription());
			ps.setString(3, n.getUserName());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<News> getNews() {
		List<News> list = new ArrayList<News>();
		try {
			String sql = "select * from newsAdd order by id DESC";
			News news = null;

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setDescription(rs.getString(3));
				news.setUserName(rs.getString(4));
				news.setDate(rs.getTimestamp(5));
				list.add(news);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public News getOneNews(int id) {
		News news = null;
		try {
			String sql = "select * from newsAdd where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setDescription(rs.getString(3));
				news.setUserName(rs.getString(4));
				news.setDate(rs.getTimestamp(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

	public boolean addComment(Comment c) {
		
	boolean f=false;
	try {
		String sql="insert into comment(username,usercomment,newsid) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,c.getUserName());
		ps.setString(2,c.getComment());
		ps.setInt(3, c.getNewsId());
		int i=ps.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;	
	}
	
	public List<Comment> getComment(int id)
	{
		List<Comment> list=new ArrayList<Comment>();
		Comment comm=null;
		try {
			String sql="select * from comment where newsid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				comm=new Comment();
				comm.setId(rs.getInt(1));
				comm.setUserName(rs.getString(2));
				comm.setComment(rs.getString(3));
				comm.setNewsId(rs.getInt(4));
				list.add(comm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
