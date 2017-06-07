package com.spider.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	//使用饿汉式单例模式
	
	private static DbUtil util=new DbUtil();
	
	private DbUtil() {
		try {
			//加载JDBC驱动（使用饿汉式单例模式只加载一次，降低用户对数据库的访问压力）
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbUtil getInstance() {
		return util;
	}
	
	Connection conn;
	//连接数据库
	public Connection getConnection() {
		try {
			//建立链接
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","zsf");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	//关闭数据库
	public void closeConnnection(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
