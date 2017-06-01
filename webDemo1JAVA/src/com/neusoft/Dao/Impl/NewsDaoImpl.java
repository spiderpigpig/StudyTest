package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.util.DbUtil;
import com.neusoft.bean.News;
public class NewsDaoImpl implements QingHaiDao<News> {
	DbUtil util = DbUtil.getInstance();

	@Override
	public int insert(News t) {
		
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "INSERT INTO QINGHAI_NEWS VALUES(NEWSID.NEXTVAL,SYSDATE,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, t.getTitle());
			statement.setString(2, t.getNewsContent());
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		
		return resultCode;
	}

	@Override
	public int delete(String where) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "DELETE FROM QINGHAI_NEWS WHERE "+where;
		System.out.println(sql);
		try {
			statement = conn.prepareStatement(sql);
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		
		return resultCode;
	}

	@Override
	public int update(News t) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "UPDATE QINGHAI_NEWS SET NEWSDATE=SYSDATE,TITLE=?,NEWSCONTENT=? WHERE NEWSID="+t.getNewsID();
		System.out.println(sql);
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, t.getTitle());
			statement.setString(2, t.getNewsContent());
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		
		return resultCode;
	}

	@Override
	public List<News> findAll(String where) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		List<News> list = new ArrayList<>();
		ResultSet resultSet;
		String sql = "SELECT * FROM QINGHAI_NEWS " + where;
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				News t = new News();
				t.setNewsID(resultSet.getInt("newsid"));
				t.setNewsDate(resultSet.getDate("newsdate"));
				t.setTitle(resultSet.getString("title"));
				t.setNewsContent(resultSet.getString("newsContent"));
				list.add(t);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnection();
		}
		return list;
	}
	

}
