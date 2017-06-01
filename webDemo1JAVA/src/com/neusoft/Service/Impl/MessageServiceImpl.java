package com.neusoft.Service.Impl;

import java.util.List;

import com.neusoft.Dao.QingHaiDao;
import com.neusoft.Dao.Impl.MessageDaoImpl;
import com.neusoft.Service.QingHaiService;
import com.neusoft.bean.Message;

public class MessageServiceImpl<Message> implements QingHaiService<Message> {

	@Override
	public int insert(Message t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new MessageDaoImpl();
		return dao.insert(t);
	}

	@Override
	public int delete(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new MessageDaoImpl();
		return dao.delete(where);
	}

	@Override
	public int update(Message t) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new MessageDaoImpl();
		return dao.update(t);
	}

	@Override
	public List<Message> findAll(String where) {
		// TODO 自动生成的方法存根
		QingHaiDao dao = new MessageDaoImpl();
		return dao.findAll(where);
	}

	

}
