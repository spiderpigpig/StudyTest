package com.spider.service.impl;

import java.util.List;

import com.spider.bean.DVDUser;
import com.spider.dao.ObjectDao;
import com.spider.dao.impl.DVDUserDaoImpl;
import com.spider.service.DVDUserService;

public class DVDUserServiceImpl implements DVDUserService{


	public List<DVDUser> findAll(String where) {
		ObjectDao<DVDUser> dao=new DVDUserDaoImpl();
		return dao.findAll(where);
	}
	
	
	public List<DVDUser> findOne(DVDUser t) {
		ObjectDao<DVDUser> dao=new DVDUserDaoImpl();
		return dao.findOne(t);
	}

	
	public int Insert(DVDUser t) {
		ObjectDao<DVDUser> dao=new DVDUserDaoImpl();
		return dao.Insert(t);
	}


	public int Delete(DVDUser t) {
		ObjectDao<DVDUser> dao=new DVDUserDaoImpl();
		return dao.Delete(t);
	}


	public int Update(DVDUser t) {
		ObjectDao<DVDUser> dao=new DVDUserDaoImpl();
		return dao.Update(t);
	}

}
