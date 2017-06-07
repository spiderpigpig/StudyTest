package com.spider.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	//ʹ�ö���ʽ����ģʽ
	
	private static DbUtil util=new DbUtil();
	
	private DbUtil() {
		try {
			//����JDBC������ʹ�ö���ʽ����ģʽֻ����һ�Σ������û������ݿ�ķ���ѹ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DbUtil getInstance() {
		return util;
	}
	
	Connection conn;
	//�������ݿ�
	public Connection getConnection() {
		try {
			//��������
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","zsf");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	//�ر����ݿ�
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
