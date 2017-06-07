package com.spider.control;

import java.util.List;
import java.util.Scanner;

import com.spider.bean.DVD;
import com.spider.bean.DVDUser;
import com.spider.service.DVDService;
import com.spider.service.DVDUserService;
import com.spider.service.impl.DVDServiceImpl;
import com.spider.service.impl.DVDUserServiceImpl;
import com.spider.tool.Tool;
import com.spider.view.DVDView;


public class DVDControl {
	
	public void startMenu() {
		Scanner scan=new Scanner(System.in);
		Tool tool =new Tool();
		DVDService service=new DVDServiceImpl();
		DVDView view=new DVDView();
		int choice=0;
		System.out.print("欢迎使用");
		do {
			view.returnMain();
			System.out.print("请选择：");
			choice=tool.nextInt();
			switch (choice) {
			case 0:
				break;
			case 1:
				System.out.println("--->新增DVD\n");
				insertDVD();
				break;
			case 2:
				String choiceString;
				do {
					System.out.println("--->查看DVD\n");
					System.out.println("序号\tDVD名称\t\t状态\t借出日期\t\t租借价格(单日)");
					for (DVD dvd: service.findAll("")) {
						if (dvd.getLendState()!=-1) {
							System.out.println(dvd.toString());
						}
					}
					System.out.print("输入0返回：");
					choiceString=scan.next();
				} while (!"0".equals(choiceString));
				break;
			case 3:
				System.out.println("--->下架DVD\n");
				deleteDVD();
				break;
			case 4:
				System.out.println("--->借出DVD\n");
				DVDlend();
				break;
			case 5:
				System.out.println("--->归还DVD\n");
				DVDreturn();
				break;
			case 6:
				System.out.println("--->DVD排行榜\n");
				DVDcharts();
				break;
			case 7:
				System.out.println("--->办理会员卡\n");
				insertUser();
				break;
			default:
				System.out.println("输入有误!");
				break;
			}
		} while (choice!=0);
		System.out.print("\n已退出迷你DVD管理系统");
	}
	
	public void insertDVD() {
		Tool tool =new Tool();
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVD dvd=new DVD();
		System.out.print("请输入新增DVD的名字：");
		String dvdName=scan.next();
		dvdName="《"+dvdName+"》";
		dvd.setDvdName(dvdName);
		List<DVD> list=service.findOne(dvd);
		if(list.size()==0){
			System.out.print("请输入新增DVD的租价：");
			Double dvdPrice=tool.nextDouble();
			dvd.setDvdPrice(dvdPrice);
			if(service.Insert(dvd)>0){
				System.out.println(dvdName+"新增成功");
			}else {
				System.out.println(dvdName+"新增失败");
			}
		}else if (list.get(0).getLendState()==-1) {
			dvd=list.get(0);
			System.out.print("请输入新增DVD的租价：");
			Double dvdPrice=tool.nextDouble();
			dvd.setDvdPrice(dvdPrice);
			dvd.setLendState(1);
			if(service.Update(dvd)>0){
				System.out.println(dvdName+"新增成功");
			}else {
				System.out.println(dvdName+"新增失败");
			}
		}
		else {
			System.out.println("已有该DVD"+dvdName+",无法添加！");
		}
		System.out.print("输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			insertDVD();
		}
	}

	public void deleteDVD() {
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVD dvd=new DVD();
		System.out.print("请输入欲下架DVD的名字：");
		String dvdName=scan.next();
		dvdName="《"+dvdName+"》";
		dvd.setDvdName(dvdName);
		List<DVD> list=service.findOne(dvd);
		if(list.size()==0||list.get(0).getLendState()==-1){
			System.out.println("没有与"+dvdName+"相关的DVD,请检查输入是否准确");
		}else if(list.get(0).getLendState()==1){
			dvd=list.get(0);
			dvd.setLendState(-1);
			service.Update(dvd);
			System.out.println("已下架"+dvdName);
		}else {
			System.out.println(dvdName+"被借出，未归还，无法下架！");
		}
		System.out.print("输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			deleteDVD();
		}
	}
	
	public void DVDlend() {
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVDUserService serviceUser=new DVDUserServiceImpl();
		DVD dvd=new DVD();
		DVDUser user=new DVDUser();
		Tool tool=new Tool();
		System.out.print("请刷卡(输入会员卡号)：");
		Integer userID=tool.nextInt();
		user.setUserId(userID);
		dvd.setLendState(userID);
		List<DVDUser> listUser = serviceUser.findOne(user);
		if (listUser.size()==0) {
			System.out.println("该会员号不存在");
		}else if (service.findOne(dvd).size()>0) {
			System.out.println("你借过一盘DVD了，不许再借了");
			System.out.println("你骂了一句“什么破店”");
		}else {
			System.out.println("欢迎光临	"+listUser.get(0).getUserName());
			System.out.print("请输入欲借出DVD的名字：");
			String dvdName=scan.next();
			dvdName="《"+dvdName+"》";
			dvd.setDvdName(dvdName);
			List<DVD> list=service.findOne(dvd);
			if(list.size()==0||list.get(0).getLendState()==-1){
				System.out.println("没有与"+dvdName+"相关的DVD,请检查输入是否准确");
			}else if(list.get(0).getLendState()==1){
				System.out.println(dvdName+"需要"+list.get(0).getDvdPrice()*10+"元押金");
				Double money=list.get(0).getDvdPrice()*10-listUser.get(0).getDeposit();
				if (money<=0) {
					System.out.println("会员卡余额为"+listUser.get(0).getDeposit()+"元,可以租借");
				}else {
					System.out.println("会员卡余额为"+listUser.get(0).getDeposit()+"元,余额不足请充值");
					System.out.println("DVD商店抢钱"+money+"元");
					user=listUser.get(0);
					user.setDeposit(user.getDeposit()+money);
					if (money>=100&&money<200&&user.getUserType()<1) {
						user.setUserType(1);
						user.setBorrowNum(1);
					}else if (money>=200&&money<300&&user.getUserType()<2) {
						user.setUserType(2);
						user.setBorrowNum(2);
					}else if (money>=300&&user.getUserType()<3) {
						user.setUserType(3);
						user.setBorrowNum(5);
					}
					if (serviceUser.Update(user)>0) {
						System.out.println("成功充值");
						if (money>=100&&money<200) {
							System.out.println(userID+"会员升级为黄金会员");
						}else if (money>=200&&money<300) {
							System.out.println("会员升级为铂金会员");
						}else if (money>=300) {
							System.out.println("会员升级为钻石会员");
						}
					}else {
						System.out.println("但是充钱失败，还不打算还钱，赶紧报警吧！");
					}
				}
				dvd=list.get(0);
				dvd.setLendState(userID);
				java.sql.Date sqlDate=null;
				do{
					System.out.print("请输入借出日期：");
					String dateString=scan.next();
					sqlDate= tool.date(dateString);
					if (sqlDate!=null) {
						dvd.setLendDate(sqlDate);
					}else {
						System.out.println("日期输入不正确");
					}
				}while(sqlDate==null);
				dvd.setLendNum(dvd.getLendNum()+1);
				service.Update(dvd);
				System.out.println("已借出"+dvdName);
			}else {
				System.out.println(dvdName+"被借未还,无法借出");
			}
		}
		
		System.out.print("输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			DVDlend();
		}
	}
	
	public void DVDreturn() {
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVDUserService serviceUser= new DVDUserServiceImpl();
		DVD dvd=new DVD();
		DVDUser user =new DVDUser();
		Tool tool=new Tool();
		System.out.print("请刷卡(输入会员卡号)：");
		Integer userID=tool.nextInt();
		user.setUserId(userID);
		dvd.setLendState(userID);
		List<DVDUser> listUser = serviceUser.findOne(user);
		if (listUser.size()==0) {
			System.out.println("该会员号不存在");
		}else if (service.findOne(dvd).size()==0) {
			System.out.println("你还没借过DVD，倒啥乱");
		}else {
			System.out.println("欢迎光临	"+listUser.get(0).getUserName());
			System.out.print("请输入欲归还DVD的名字：");
			String dvdName=scan.next();
			dvdName="《"+dvdName+"》";
			dvd.setDvdName(dvdName);
			List<DVD> list =service.findOne(dvd);
			if(list.size()==0||list.get(0).getLendState()==-1){
				System.out.println("没有与"+dvdName+"相关的DVD,请检查输入是否准确");
			}else if(list.get(0).getLendState()==1){
				System.out.println(dvdName+"未被借出,无法归还");
			}else if (!list.get(0).getLendState().equals(userID)) {
				System.out.println("你没借这盘DVD，倒啥乱");
			}else {
				dvd=list.get(0);
				java.sql.Date lendDate=dvd.getLendDate();
				dvd.setLendState(1);
				java.sql.Date returnDate=null;
				do{
					System.out.print("请输入归还日期：");
					String dateString=scan.next();
					returnDate= tool.date(dateString);
					if (returnDate==null) {
						System.out.println("日期输入不正确");
					}else if (returnDate.getTime()-lendDate.getTime()<0) {
						System.out.println("日期输入不能比借出日期早");
					}else {
						break;
					}
				}while(true);
				dvd.setLendDate(null);
				if (service.Update(dvd)>0) {
					System.out.println("借出日期为"+lendDate);
					System.out.println("归还日期为"+returnDate);
					System.out.println("共租借"+((returnDate.getTime()-lendDate.getTime())/1000/3600/24+1)+"天");
					user=serviceUser.findOne(user).get(0);
					if (returnDate.getYear()-lendDate.getYear()==0&&returnDate.getMonth()-lendDate.getMonth()==0&&user.getBorrowNum()>0) {
						user.setBorrowNum(user.getBorrowNum()-1);
						System.out.println(user.getUserName()+"本次免费租借，本月剩余免费次数："+user.getBorrowNum()+"次");
						serviceUser.Update(user);
					}else {
						if (user.getBorrowNum()==0) {
							System.out.println("你本月没有免费租借次数了");
						}else if (returnDate.getMonth()-lendDate.getMonth()!=0||returnDate.getYear()-lendDate.getYear()!=0) {
							System.out.println("你租借DVD没有在当月还，所以不能免费");
						}
						System.out.println(dvdName+"单日租借价格为"+dvd.getDvdPrice()+"元");
						//租金总计
						Double rent=dvd.getDvdPrice()*((returnDate.getTime()-lendDate.getTime())/1000/3600/24+1);
						System.out.println("租金共计"+rent+"元");
						System.out.println("卡内余额"+user.getDeposit()+"元");
						Double depositBefore=user.getDeposit();
						Double depositNew=depositBefore-rent;
						if (depositNew>=0) {
							user.setDeposit(depositNew);
						}else {
							user.setDeposit(0.0);
						}
						if (serviceUser.Update(user)>0) {
							if (depositNew>=0) {
								System.out.println("从会员"+user.getUserId()+"处扣除租金"+rent+"元");
							}else {
								System.out.println("从会员"+user.getUserId()+"处扣除租金"+depositBefore+"元");
								System.out.println("DVD商店抢走你"+(0.0-depositNew)+"元");
							}
							System.out.println("卡内余额"+user.getDeposit()+"元");
						}else {
							System.out.println("租金扣除失败");
						}
						System.out.println("已归还"+dvdName);
					}
					
				}else {
					System.out.println("归还DVD失败");
				}
			}
		}
		System.out.print("输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			DVDreturn();
		}
	}
	public void DVDcharts() {
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		List<DVD> list =service.findAll("");
		list=service.sort(list);
		System.out.println("租借次数\t  DVD名称");
		for (DVD dvd : list) {
			System.out.println("  "+dvd.getLendNum()+"\t"+dvd.getDvdName());
		}
		System.out.print("输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			DVDcharts();
		}
	}
	public void insertUser() {
		Tool tool =new Tool();
		Scanner scan=new Scanner(System.in);
		DVDUserService service=new DVDUserServiceImpl();
		DVDView view=new DVDView();
		DVDUser user=new DVDUser();
		System.out.print("请输入新增会员姓名：");
		String username=scan.next();
		user.setUserName(username);
		view.showUserType();
		Double deposit;
		do {
			System.out.print("请输入会员充值的金额：");
			deposit=tool.nextDouble();
			if (deposit<0) {
				System.out.println("输入有误");
			}else if (deposit>=0&&deposit<100) {
				System.out.println("用户办理普通会员");
				user.setUserType(0);
				user.setBorrowNum(0);
				break;
			}else if (deposit>=100&&deposit<200) {
				System.out.println("用户办理黄金会员");
				user.setUserType(1);
				user.setBorrowNum(1);
				break;
			}else if (deposit>=200&&deposit<300) {
				System.out.println("用户办理铂金会员");
				user.setUserType(2);
				user.setBorrowNum(2);
				break;
			}else if (deposit>=300) {
				System.out.println("用户办理钻石会员");
				user.setUserType(3);
				user.setBorrowNum(5);
				break;
			}
		} while (true);
		user.setDeposit(deposit);
		if(service.Insert(user)>0){
			System.out.println("会员"+username+"新增成功");
			System.out.println("会员卡卡号：“"+service.findOne(user).get(0).getUserId()+"”\n丢失不补哦");
		}else {
			System.out.println(username+"新增失败");
		}
		System.out.print("\n输入0返回：");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			insertUser();
		}
	}
	
}
