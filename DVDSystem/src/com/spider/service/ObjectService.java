package com.spider.service;

import java.util.List;


public interface ObjectService<T> {
	public List<T> findAll(String where);
	public List<T> findOne(T t);
	public int Insert(T t);
	public int Delete(T t);
	public int Update(T t);
}
