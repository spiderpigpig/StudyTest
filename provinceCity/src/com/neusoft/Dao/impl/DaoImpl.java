package com.neusoft.Dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.util.DbUtil;

public class DaoImpl {

	private DbUtil util = DbUtil.getInstance();
	
	public List<String> findProvince(){
		List<String> list = new ArrayList<>();
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT PROVINCENAME FROM CITY GROUP BY PROVINCENAME";
		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getString("provincename"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnnection(conn);
		}
		return list;
		
	}
	public List<String> findCity(String cityName){
		List<String> list = new ArrayList<>();
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT CITYNAME FROM CITY WHERE PROVINCENAME=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, cityName);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getString("cityname"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			util.closeConnnection(conn);
		}
		return list;
		
	}
	
	public List<Object> findAll(Object object,String sql) {
		Class cls = object.getClass();
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		List<Object> list = new ArrayList<>();
		try {
			statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Object obj = cls.newInstance();
				Field [] fields = cls.getDeclaredFields();
				String fieldName = null;
				for(int i = 0; i < fields.length; i++){
					Field field = fields[i];
					field.setAccessible(true);
					fieldName = field.getName();
					if(fieldName.equals("permission")){
						fieldName = "userpermission";
					}
					Object value = null;
					Class type = field.getType();  
	                if(type.toString().equals("class java.lang.String")){  
	                	value = resultSet.getString(fieldName.toLowerCase());
	                }  
	                else if(type.toString().equals("class java.util.Date")){  
	                	value = resultSet.getDate(fieldName.toLowerCase()); 
	                }  
	                else if(type.toString().equals("class java.lang.Integer")){  
	                	value = resultSet.getInt(fieldName.toLowerCase());
	                }
	                field.set(obj,value); 
				}
				list.add(obj);
			}
			
			
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  finally {
			util.closeConnnection(conn);
		}
		return list;
	}

	public int insertUpdateDelete(String sql,Object[] params) {
		// TODO 自动生成的方法存根
		Connection conn = util.getConnection();
		PreparedStatement statement = null;
		int returnCode = -1;
		
		System.out.println(sql);
		try {
			statement = conn.prepareStatement(sql);
			for(int i = 1; i <= params.length; i++){
			
				statement.setObject(i,params[i-1]);
			}
			returnCode = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			util.closeConnnection(conn);
		}
		return returnCode;
	}
	
	
}
