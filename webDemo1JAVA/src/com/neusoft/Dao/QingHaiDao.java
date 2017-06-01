package com.neusoft.Dao;

import java.util.List;

public interface QingHaiDao<T> {
	public int insert(T t);
	public int delete(String where);
	public int update(T t);
	public List<T> findAll(String where);
}
