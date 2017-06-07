package com.spider.service.impl;

import java.util.List;
import com.spider.bean.DVD;
import com.spider.dao.ObjectDao;
import com.spider.dao.impl.DVDDaoImpl;
import com.spider.service.DVDService;


public class DVDServiceImpl implements DVDService {


	public List<DVD> findAll(String where) {
		ObjectDao<DVD> dao=new DVDDaoImpl();
		return dao.findAll(where);
	}

	
	public List<DVD> findOne(DVD t) {
		ObjectDao<DVD> dao=new DVDDaoImpl();
		return dao.findOne(t);
	}

	
	public int Insert(DVD t) {
		ObjectDao<DVD> dao=new DVDDaoImpl();
		return dao.Insert(t);
	}


	public int Delete(DVD t) {
		ObjectDao<DVD> dao=new DVDDaoImpl();
		return dao.Delete(t);
	}


	public int Update(DVD t) {
		ObjectDao<DVD> dao=new DVDDaoImpl();
		return dao.Update(t);
	}

	public List<DVD> sort(List<DVD> list) {
		DVD temp = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size()-i-1; j++) {
				if (list.get(j+1).getLendNum()>list.get(j).getLendNum()) {
					temp=list.get(j+1);
					list.set(j+1,list.get(j));
					list.set(j,temp);
				}
			}
		}
		return list;
	}




;




}
