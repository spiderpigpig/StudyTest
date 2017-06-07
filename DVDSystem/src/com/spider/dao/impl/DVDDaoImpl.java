package com.spider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spider.bean.DVD;
import com.spider.dao.ObjectDao;
import com.spider.util.DbUtil;


public class DVDDaoImpl implements ObjectDao<DVD>{
	
	private DbUtil util=DbUtil.getInstance();

	public List<DVD> findAll(String where) {
		Connection conn = util.getConnection();
		PreparedStatement statement;
	    ResultSet rs;
	    List<DVD> list = new ArrayList<DVD>();
	    try {
	    	String sql = "SELECT * FROM T_DVDINFO WHERE 1=1 " + where;
	    	statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()){
				DVD dvd = new DVD();
				dvd.setDvdId(rs.getInt("dvdid"));
				dvd.setDvdName(rs.getString("dvdname"));
				dvd.setLendState(rs.getInt("lendstate"));
				dvd.setLendDate(rs.getDate("lenddate"));
				dvd.setDvdPrice(rs.getDouble("dvdprice"));
				dvd.setLendNum(rs.getInt("lendnum"));
				list.add(dvd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.closeConnnection(conn);
		}
		return list;
	}

	public List<DVD> findOne(DVD t) {
		String where="";
		if (t.getDvdName()!=null) {
			where=" AND DVDNAME = '"+t.getDvdName()+"'";
		}else if (t.getLendState()!=null) {
			where=" AND LENDSTATE = '"+t.getLendState()+"'";
		}
		
		return findAll(where);
	}

	public int Insert(DVD dvd) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="INSERT INTO T_DVDINFO (DVDID,DVDNAME,DVDPRICE) VALUES (TDVDID.NEXTVAL,?,?)";
			statement =conn.prepareStatement(sql);
			statement.setString(1, dvd.getDvdName());
			statement.setDouble(2, dvd.getDvdPrice());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}

	public int Delete(DVD dvd) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="DELETE FROM T_DVDINFO WHERE DVDNAME=?";
			statement =conn.prepareStatement(sql);
			statement.setString(1, dvd.getDvdName());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}

	public int Update(DVD dvd) {
		Connection conn=util.getConnection();
		PreparedStatement statement;
		int i=0;
		try {
			String sql="UPDATE T_DVDINFO SET DVDNAME=?,LENDSTATE=?,LENDDATE=?,DVDPRICE=?,LENDNUM=? WHERE DVDID=?";
			statement =conn.prepareStatement(sql);
			statement.setString(1, dvd.getDvdName());
			statement.setInt(2, dvd.getLendState());
			statement.setDate(3, dvd.getLendDate());
			statement.setDouble(4, dvd.getDvdPrice());
			statement.setInt(5, dvd.getLendNum());
			statement.setInt(6, dvd.getDvdId());
			i =statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConnnection(conn);
		}
		return i;
	}



	
}
