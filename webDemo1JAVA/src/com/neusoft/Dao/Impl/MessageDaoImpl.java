package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.bean.Message;
import com.neusoft.util.DbUtil;


public class MessageDaoImpl implements QingHaiDao<Message> {
	DbUtil util = DbUtil.getInstance();

	@Override
	public int insert(Message t) {
		
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1 ;
		String sql = "INSERT INTO QINGHAI_MESSAGE VALUES(MESSAGEID.NEXTVAL,SYSDATE,?,?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, t.getUsername());
			statement.setString(2, t.getTelephone());
			statement.setString(3, t.getEmail());
			statement.setString(4, t.getAddress());
			statement.setString(5, t.getMessage());
			System.out.println(t);
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
		String sql = "DELETE FROM QINGHAI_MESSAGE WHERE "+where;
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
	public int update(Message t) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public List<Message> findAll(String where) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement;
		List<Message> list = new ArrayList<>();
		ResultSet resultSet;
		String sql = "SELECT * FROM QINGHAI_MESSAGE " + where;
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Message t = new Message();
				t.setMessageid(resultSet.getInt("messageid"));
				t.setMessageDate(resultSet.getDate("messageDate"));
				t.setUsername(resultSet.getString("username"));
				t.setTelephone(resultSet.getString("telephone"));
				t.setEmail(resultSet.getString("email"));
				t.setAddress(resultSet.getString("address"));
				t.setMessage(resultSet.getString("message"));
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
