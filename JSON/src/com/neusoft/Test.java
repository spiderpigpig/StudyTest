package com.neusoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args){
		System.out.println("单个JSONObject");
		String jsonObjectStr = "{id:100,name:\"spider\",email:\"234@qq.com\"}";
		JSONObject jsonObject = JSONObject.fromObject(jsonObjectStr);
		Account account = new Account();
		account.setId(jsonObject.getInt("id"));
		account.setName(jsonObject.getString("name"));
		account.setEmail(jsonObject.getString("email"));
		System.out.println(account.toString());
		Account a2 = (Account)JSONObject.toBean(jsonObject,Account.class);
		System.out.println(a2);
		
		System.out.println("数组JSONOArray");
		String jsonArrayStr = "[{id:100,name:\"spider\",email:\"234@qq.com\"},{id:101,name:\"spider\",email:\"234@qq.com\"},{id:102,name:\"spider\",email:\"234@qq.com\"}]";
		JSONArray jsonArray = JSONArray.fromObject(jsonArrayStr);
		
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObA = iterator.next();
			/*Account accountA = new Account();
			accountA.setId(jsonObA.getInt("id"));
			accountA.setName(jsonObA.getString("name"));
			accountA.setEmail(jsonObA.getString("email"));
			System.out.println(accountA.toString());*/
			Account a3 = (Account)JSONObject.toBean(jsonObA,Account.class);
			System.out.println(a3);
		}
		System.out.println("转换JSON");
		System.out.println(toJSON(account));
		System.out.println("转换JSON数组");
		List<Account> list = new ArrayList<>();
		list.add(account);
		list.add(account);
		list.add(account);
		System.out.println(toJSONArray(list));
		System.out.println("===========");
		url();
		
	}
	public static JSONObject toJSON(Account account){
		JSONObject jo = new JSONObject();
		jo.put("id", account.getId());
		jo.put("name", account.getName());
		jo.put("email", account.getEmail());
		return jo;
	}
	public static JSONArray toJSONArray(List<Account> list){
		JSONArray ja = new JSONArray();
		/*for(int i = 0; i < list.size(); i++){
			ja.add(list.get(i));
		}*/
		ja.addAll(list);
		return ja;
	}
	public static void url(){
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		JSONObject jsonObject = null;
		
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
			jsonObject = JSONObject.fromObject(JSONArrayStr);
			Book book = (Book) jsonObject.toBean(jsonObject, Book.class);
			System.out.println(book);
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
