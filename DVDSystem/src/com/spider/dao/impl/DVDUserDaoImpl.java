package com.spider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spider.bean.DVDUser;
import com.spider.dao.ObjectDao;
import com.spider.util.DbUtil;


public class DVDUserDaoImpl implements ObjectDao<DVDUser>{
	
	private DbUtil util=DbUtil.getInstance();

	public List<DVDUser> findAll(String where) {
		Connection conn = util.getConnection();
		PreparedStatement statement;
	    ResultSet rs;
	    List<DVDUser> list = new ArrayList<DVDUser>();
	    try {
	    	String sql = "SELECT * FROM T_DVDUSER WHERE 1=1 " + where;
	    	statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()){
				DVDUser DVDUser = new DVDUser();
				DVDUser.setUserId(rs.getInt("userid"));
				DVDUser.setUserName(rs.getString("username"));
				DVDUser.setUserType(rs.getInt("usertype"));
				DVDUser.setDeposit(rs.getDouble("deposit"));
				DVDUser.setBorrowNum(rs.getInt("borrownum"));
				list.add(DVDUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnnection(conn);
		}
		return list;
	}

	public List<DVDUser> findOne(DVDUser t) {
		String where="";
		if (t.getUserId()!=null) {
			where=" AND USERID = '"+t.getUserId()+"'";
		}else if (t.getUserName()!=null){
			where=" AND USERNAME = '"+t.getUserName()+"'";
		}
		return findAll(where);
	}

	public int Insert(DVDUser DVDUser) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="INSERT INTO T_DVDUSER  VALUES (TDVDUSERID.NEXTVAL,?,?,?,?)";
			statement =conn.prepareStatement(sql);
			statement.setString(1, DVDUser.getUserName());
			statement.setInt(2, DVDUser.getUserType());
			statement.setDouble(3, DVDUser.getDeposit());
			statement.setInt(4, DVDUser.getBorrowNum());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}

	public int Delete(DVDUser DVDUser) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="DELETE FROM T_DVDUSER WHERE USERNAME=?";
			statement =conn.prepareStatement(sql);
			statement.setString(1, DVDUser.getUserName());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}

	public int Update(DVDUser DVDUser) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="UPDATE T_DVDUSER SET USERNAME=?,USERTYPE=?,DEPOSIT=?,BORROWNUM=? WHERE USERID=?";
			statement =conn.prepareStatement(sql);
			statement.setString(1, DVDUser.getUserName());
			statement.setInt(2, DVDUser.getUserType());
			statement.setDouble(3, DVDUser.getDeposit());
			statement.setInt(4, DVDUser.getBorrowNum());
			statement.setInt(5, DVDUser.getUserId());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}



	
}
