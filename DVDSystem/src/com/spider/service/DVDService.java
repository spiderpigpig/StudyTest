package com.spider.service;


import java.util.List;

import com.spider.bean.DVD;

public interface DVDService extends ObjectService<DVD>{
	public List<DVD> sort(List<DVD> list);


}
