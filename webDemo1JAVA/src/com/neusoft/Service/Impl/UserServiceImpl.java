package com.neusoft.Service.Impl;

import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.Dao.Impl.UserDaoImpl;
import com.neusoft.Service.QingHaiService;

public class UserServiceImpl<User> implements QingHaiService<User> {

	@Override
	public int insert(User t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new UserDaoImpl();
		return dao.insert(t);
	}

	@Override
	public int delete(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new UserDaoImpl();
		return dao.delete(where);
	}

	@Override
	public int update(User t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new UserDaoImpl();
		return dao.update(t);
	}

	@Override
	public List<User> findAll(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new UserDaoImpl();
		return dao.findAll(where);
	}

	public List<User> check(String username, String password) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new UserDaoImpl();
		String where = "WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
		return dao.findAll(where);
	}

}
