package com.neusoft;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;


public class AliJson {
	public static void main(String[] args) {
		listToJson();
		objectToJson();
	}
	public static void jsonToObject(){
		String jsonStr = "{\"id\":101,\"name\":\"spider\",\"email\":\"email\"}";	
		Account account = JSON.parseObject(jsonStr, Account.class);
		System.out.println(account);
	}
	public static void jsonToList(){
		String jsonStr = "[{\"id\":101,\"name\":\"spider\",\"email\":\"email\"},{\"id\":102,\"name\":\"spider\",\"email\":\"email\"},{\"id\":103,\"name\":\"spider\",\"email\":\"email\"}]";	
		List<Account> list = JSON.parseArray(jsonStr, Account.class);
		System.out.println(list);
	}
	public static void objectToJson(){
		Account account = new Account(120,"spider120","email120");
		String json = JSON.toJSONString(account);
		System.out.println(json);
	}
	public static void listToJson(){
		List<Account> list = new ArrayList<>();
		list.add(new Account(120,"spider120","email120"));
		list.add(new Account(122,"spider120","email120"));
		list.add(new Account(124,"spider120","email120"));
		String json = JSON.toJSONString(list);
		System.out.println(json);
	}
}
