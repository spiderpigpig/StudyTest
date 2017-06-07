package com.spider.view;


public class DVDView {

	
	public void returnMain() {
		System.out.println("\n迷你DVD管理器");
		System.out.println("----------");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.下架DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.DVD排行榜");
		System.out.println("7.办理会员卡");
		System.out.println("0.退出");
		System.out.println("----------");
	}
	
	public void showUserType() {
		System.out.println("-----------------------------------");
		System.out.println("充值满100元，成为黄金会员，每月免费借1张DVD");
		System.out.println("充值满200元，成为铂金会员，每月免费借2张DVD");
		System.out.println("充值满300元，成为钻石会员，每月免费借5张DVD");
		System.out.println("-----------------------------------");
	}

}
