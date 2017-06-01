package com.neusoft.Service.Impl;

import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.Dao.Impl.NewsDaoImpl;
import com.neusoft.Service.QingHaiService;
import com.neusoft.bean.News;

public class NewsServiceImpl<News> implements QingHaiService<News> {

	@Override
	public int insert(News t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new NewsDaoImpl();
		return dao.insert(t);
	}

	@Override
	public int delete(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new NewsDaoImpl();
		return dao.delete(where);
	}

	@Override
	public int update(News t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new NewsDaoImpl();
		return dao.update(t);
	}

	@Override
	public List<News> findAll(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new NewsDaoImpl();
		return dao.findAll(where);
	}


}
