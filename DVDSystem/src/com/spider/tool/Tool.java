package com.spider.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tool {
	public java.sql.Date date(String dateString) {
		Date utildate=null;
		java.sql.Date sqldate=null;
		try {
			utildate=new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			sqldate=new java.sql.Date(utildate.getTime());
			
		} catch (ParseException e) {
			
		}
		return sqldate;
	}
	
	public int nextInt() {
		Scanner scan =new Scanner(System.in);
		int i;
		while (true) {
			try {
				i=scan.nextInt();
				break;
			} catch (Exception e) {
				scan.next();
				System.out.print("输入有误,请输入整数数字：");
			}
		}
		return i;
	}
	
	public Double nextDouble() {
		Scanner scan =new Scanner(System.in);
		Double i;
		while (true) {
			try {
				i=scan.nextDouble();
				break;
			} catch (Exception e) {
				scan.next();
				System.out.print("输入有误,请输入纯数字：");
			}
		}
		return i;
	}
}
