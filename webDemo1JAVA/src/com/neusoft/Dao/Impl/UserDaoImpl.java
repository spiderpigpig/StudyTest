package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.util.DbUtil;


import com.neusoft.bean.User;
public class UserDaoImpl implements QingHaiDao<User> {
	DbUtil util = DbUtil.getInstance();

	@Override
	public int insert(User t) {
		
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "INSERT INTO QINGHAI_USER VALUES(USERID.NEXTVAL,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setInt(3, t.getStatus());
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
		String sql = "DELETE FROM QINGHAI_USER WHERE "+where;
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
	public int update(User t) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "UPDATE QINGHAI_USER SET USERNAME=?,PASSWORD=?,STATUS=? WHERE USERID='"+t.getUserID()+"'";
		System.out.println(sql);
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setInt(3, t.getStatus());
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
	public List<User> findAll(String where) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		List<User> list = new ArrayList<>();
		ResultSet resultSet;
		String sql = "SELECT * FROM QINGHAI_USER " + where;
		System.out.println(sql);
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				User user = new User();
				user.setUserID(resultSet.getInt("userid"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getInt("status"));
				list.add(user);
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
