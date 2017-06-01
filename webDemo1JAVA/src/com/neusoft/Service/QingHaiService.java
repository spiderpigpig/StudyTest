package com.neusoft.Service;

import java.util.List;

public interface QingHaiService<T> {
	public int insert(T t);
	public int delete(String where);
	public int update(T t);
	public List<T> findAll(String where);
}
