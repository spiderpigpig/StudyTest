package com.neusoft.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.util.DbUtil;

public class QingHaiDaoImpl<T> implements QingHaiDao<T>{
	private static DbUtil util;
	@Override
	public int insert(T t) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int delete(String where) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int update(T t) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public List<T> findAll(String where) {
		// TODO �Զ����ɵķ������
		return null;
	}
	public int insDelUpt(String sql){
		Connection conn = util.getConnection();
		PreparedStatement statement;
		int resultCode = -1;
		try {
			statement = conn.prepareStatement(sql);
			resultCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return resultCode;
	}
	public List<T> find(String sql) {
		// TODO �Զ����ɵķ������
		return null;
	}
}
