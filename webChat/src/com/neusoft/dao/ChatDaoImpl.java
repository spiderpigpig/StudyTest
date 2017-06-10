package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bean.Chat;
import com.neusoft.util.DbUtil;

public class ChatDaoImpl {
	DbUtil util = DbUtil.getInstance();
	public int insert(String username,String talkContent){
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		int resultCode = -1;
		String sql = "INSERT INTO WEBCHAT VALUES(WEBCHAT_CHATID.NEXTVAL,?,?,SYSDATE)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, talkContent);
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			util.closeConnection();
		}
		return resultCode;
	}
	public int update(String username,String talkContent){
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		int resultCode = -1;
		String sql = "UPDATE WEBCHAT SET USERNAME=?,TALKCONTENT=?,TALKDATE=SYSDATE WHERE CHATID=(SELECT T1.CHATID FROM(SELECT * FROM WEBCHAT ORDER BY TALKDATE)T1 WHERE ROWNUM=1)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, talkContent);
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			util.closeConnection();
		}
		return resultCode;
	}
	public int findCount(){
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT COUNT(*) FROM WEBCHAT";
		int count = -1;
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				count = resultSet.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			util.closeConnection();
		}
		return count;
	}
	public List<Chat> findAll(){
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Chat> list = new ArrayList<>();
		String sql = "SELECT * FROM WEBCHAT ORDER BY TALKDATE";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Chat chat = new Chat();
				chat.setChatID(resultSet.getInt("chatid"));
				chat.setUsername(resultSet.getString("username"));
				chat.setTalkContent(resultSet.getString("talkcontent"));
				chat.setTalkDate(resultSet.getDate("talkdate"));
				list.add(chat);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			util.closeConnection();
		}
		return list;
	}
}
