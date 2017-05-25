package com.neusoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GSON {
	public static void main(String [] args){
		
		jsonToList();
	}
	public static void listToJson(){
		List<Account> list = new ArrayList<>();
		list.add(new Account(101, "spider", "email"));
		list.add(new Account(102, "spider", "email"));
		list.add(new Account(103, "spider", "email"));
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
	}
	public static void jsonToList(){
		String json = "[{\"id\":101,\"name\":\"spider\",\"email\":\"email\"},{\"id\":102,\"name\":\"spider\",\"email\":\"email\"},{\"id\":103,\"name\":\"spider\",\"email\":\"email\"}]";	
		Gson gson = new Gson();
		Type type = new TypeToken<ArrayList<Account>>(){}.getType();
		
		List<Account> list = gson.fromJson(json, type);
		System.out.println("list:"+list);
	}
	public static void gson(){
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		
		try {
			URL url = new URL("https://api.douban.com/v2/book/1220562");
			URLConnection conn = url.openConnection();
			inputStream = conn.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "Utf-8"));
			String JSONArrayStr = null;
			String line = null;
			while((line=bufferedReader.readLine())!=null){
				JSONArrayStr += line;
			}
			JSONArrayStr = JSONArrayStr.substring(4);
			Gson gson = new Gson();
			Book book = gson.fromJson(JSONArrayStr, Book.class);
			System.out.println(book);
			System.out.println("====================================");
			String json = gson.toJson(book);
			System.out.println(json);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			try {
				if(bufferedReader!=null){
					bufferedReader.close();
					bufferedReader=null;
				}
				if(inputStream!=null){
					inputStream.close();
					inputStream=null;
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
