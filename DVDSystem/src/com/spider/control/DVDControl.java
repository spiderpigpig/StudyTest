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
		System.out.print("��ӭʹ��");
		do {
			view.returnMain();
			System.out.print("��ѡ��");
			choice=tool.nextInt();
			switch (choice) {
			case 0:
				break;
			case 1:
				System.out.println("--->����DVD\n");
				insertDVD();
				break;
			case 2:
				String choiceString;
				do {
					System.out.println("--->�鿴DVD\n");
					System.out.println("���\tDVD����\t\t״̬\t�������\t\t���۸�(����)");
					for (DVD dvd: service.findAll("")) {
						if (dvd.getLendState()!=-1) {
							System.out.println(dvd.toString());
						}
					}
					System.out.print("����0���أ�");
					choiceString=scan.next();
				} while (!"0".equals(choiceString));
				break;
			case 3:
				System.out.println("--->�¼�DVD\n");
				deleteDVD();
				break;
			case 4:
				System.out.println("--->���DVD\n");
				DVDlend();
				break;
			case 5:
				System.out.println("--->�黹DVD\n");
				DVDreturn();
				break;
			case 6:
				System.out.println("--->DVD���а�\n");
				DVDcharts();
				break;
			case 7:
				System.out.println("--->�����Ա��\n");
				insertUser();
				break;
			default:
				System.out.println("��������!");
				break;
			}
		} while (choice!=0);
		System.out.print("\n���˳�����DVD����ϵͳ");
	}
	
	public void insertDVD() {
		Tool tool =new Tool();
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVD dvd=new DVD();
		System.out.print("����������DVD�����֣�");
		String dvdName=scan.next();
		dvdName="��"+dvdName+"��";
		dvd.setDvdName(dvdName);
		List<DVD> list=service.findOne(dvd);
		if(list.size()==0){
			System.out.print("����������DVD����ۣ�");
			Double dvdPrice=tool.nextDouble();
			dvd.setDvdPrice(dvdPrice);
			if(service.Insert(dvd)>0){
				System.out.println(dvdName+"�����ɹ�");
			}else {
				System.out.println(dvdName+"����ʧ��");
			}
		}else if (list.get(0).getLendState()==-1) {
			dvd=list.get(0);
			System.out.print("����������DVD����ۣ�");
			Double dvdPrice=tool.nextDouble();
			dvd.setDvdPrice(dvdPrice);
			dvd.setLendState(1);
			if(service.Update(dvd)>0){
				System.out.println(dvdName+"�����ɹ�");
			}else {
				System.out.println(dvdName+"����ʧ��");
			}
		}
		else {
			System.out.println("���и�DVD"+dvdName+",�޷���ӣ�");
		}
		System.out.print("����0���أ�");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			insertDVD();
		}
	}

	public void deleteDVD() {
		Scanner scan=new Scanner(System.in);
		DVDService service=new DVDServiceImpl();
		DVD dvd=new DVD();
		System.out.print("���������¼�DVD�����֣�");
		String dvdName=scan.next();
		dvdName="��"+dvdName+"��";
		dvd.setDvdName(dvdName);
		List<DVD> list=service.findOne(dvd);
		if(list.size()==0||list.get(0).getLendState()==-1){
			System.out.println("û����"+dvdName+"��ص�DVD,���������Ƿ�׼ȷ");
		}else if(list.get(0).getLendState()==1){
			dvd=list.get(0);
			dvd.setLendState(-1);
			service.Update(dvd);
			System.out.println("���¼�"+dvdName);
		}else {
			System.out.println(dvdName+"�������δ�黹���޷��¼ܣ�");
		}
		System.out.print("����0���أ�");
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
		System.out.print("��ˢ��(�����Ա����)��");
		Integer userID=tool.nextInt();
		user.setUserId(userID);
		dvd.setLendState(userID);
		List<DVDUser> listUser = serviceUser.findOne(user);
		if (listUser.size()==0) {
			System.out.println("�û�Ա�Ų�����");
		}else if (service.findOne(dvd).size()>0) {
			System.out.println("����һ��DVD�ˣ������ٽ���");
			System.out.println("������һ�䡰ʲô�Ƶꡱ");
		}else {
			System.out.println("��ӭ����	"+listUser.get(0).getUserName());
			System.out.print("�����������DVD�����֣�");
			String dvdName=scan.next();
			dvdName="��"+dvdName+"��";
			dvd.setDvdName(dvdName);
			List<DVD> list=service.findOne(dvd);
			if(list.size()==0||list.get(0).getLendState()==-1){
				System.out.println("û����"+dvdName+"��ص�DVD,���������Ƿ�׼ȷ");
			}else if(list.get(0).getLendState()==1){
				System.out.println(dvdName+"��Ҫ"+list.get(0).getDvdPrice()*10+"ԪѺ��");
				Double money=list.get(0).getDvdPrice()*10-listUser.get(0).getDeposit();
				if (money<=0) {
					System.out.println("��Ա�����Ϊ"+listUser.get(0).getDeposit()+"Ԫ,�������");
				}else {
					System.out.println("��Ա�����Ϊ"+listUser.get(0).getDeposit()+"Ԫ,�������ֵ");
					System.out.println("DVD�̵���Ǯ"+money+"Ԫ");
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
						System.out.println("�ɹ���ֵ");
						if (money>=100&&money<200) {
							System.out.println(userID+"��Ա����Ϊ�ƽ��Ա");
						}else if (money>=200&&money<300) {
							System.out.println("��Ա����Ϊ�����Ա");
						}else if (money>=300) {
							System.out.println("��Ա����Ϊ��ʯ��Ա");
						}
					}else {
						System.out.println("���ǳ�Ǯʧ�ܣ��������㻹Ǯ���Ͻ������ɣ�");
					}
				}
				dvd=list.get(0);
				dvd.setLendState(userID);
				java.sql.Date sqlDate=null;
				do{
					System.out.print("�����������ڣ�");
					String dateString=scan.next();
					sqlDate= tool.date(dateString);
					if (sqlDate!=null) {
						dvd.setLendDate(sqlDate);
					}else {
						System.out.println("�������벻��ȷ");
					}
				}while(sqlDate==null);
				dvd.setLendNum(dvd.getLendNum()+1);
				service.Update(dvd);
				System.out.println("�ѽ��"+dvdName);
			}else {
				System.out.println(dvdName+"����δ��,�޷����");
			}
		}
		
		System.out.print("����0���أ�");
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
		System.out.print("��ˢ��(�����Ա����)��");
		Integer userID=tool.nextInt();
		user.setUserId(userID);
		dvd.setLendState(userID);
		List<DVDUser> listUser = serviceUser.findOne(user);
		if (listUser.size()==0) {
			System.out.println("�û�Ա�Ų�����");
		}else if (service.findOne(dvd).size()==0) {
			System.out.println("�㻹û���DVD����ɶ��");
		}else {
			System.out.println("��ӭ����	"+listUser.get(0).getUserName());
			System.out.print("���������黹DVD�����֣�");
			String dvdName=scan.next();
			dvdName="��"+dvdName+"��";
			dvd.setDvdName(dvdName);
			List<DVD> list =service.findOne(dvd);
			if(list.size()==0||list.get(0).getLendState()==-1){
				System.out.println("û����"+dvdName+"��ص�DVD,���������Ƿ�׼ȷ");
			}else if(list.get(0).getLendState()==1){
				System.out.println(dvdName+"δ�����,�޷��黹");
			}else if (!list.get(0).getLendState().equals(userID)) {
				System.out.println("��û������DVD����ɶ��");
			}else {
				dvd=list.get(0);
				java.sql.Date lendDate=dvd.getLendDate();
				dvd.setLendState(1);
				java.sql.Date returnDate=null;
				do{
					System.out.print("������黹���ڣ�");
					String dateString=scan.next();
					returnDate= tool.date(dateString);
					if (returnDate==null) {
						System.out.println("�������벻��ȷ");
					}else if (returnDate.getTime()-lendDate.getTime()<0) {
						System.out.println("�������벻�ܱȽ��������");
					}else {
						break;
					}
				}while(true);
				dvd.setLendDate(null);
				if (service.Update(dvd)>0) {
					System.out.println("�������Ϊ"+lendDate);
					System.out.println("�黹����Ϊ"+returnDate);
					System.out.println("�����"+((returnDate.getTime()-lendDate.getTime())/1000/3600/24+1)+"��");
					user=serviceUser.findOne(user).get(0);
					if (returnDate.getYear()-lendDate.getYear()==0&&returnDate.getMonth()-lendDate.getMonth()==0&&user.getBorrowNum()>0) {
						user.setBorrowNum(user.getBorrowNum()-1);
						System.out.println(user.getUserName()+"���������裬����ʣ����Ѵ�����"+user.getBorrowNum()+"��");
						serviceUser.Update(user);
					}else {
						if (user.getBorrowNum()==0) {
							System.out.println("�㱾��û�������������");
						}else if (returnDate.getMonth()-lendDate.getMonth()!=0||returnDate.getYear()-lendDate.getYear()!=0) {
							System.out.println("�����DVDû���ڵ��»������Բ������");
						}
						System.out.println(dvdName+"�������۸�Ϊ"+dvd.getDvdPrice()+"Ԫ");
						//����ܼ�
						Double rent=dvd.getDvdPrice()*((returnDate.getTime()-lendDate.getTime())/1000/3600/24+1);
						System.out.println("��𹲼�"+rent+"Ԫ");
						System.out.println("�������"+user.getDeposit()+"Ԫ");
						Double depositBefore=user.getDeposit();
						Double depositNew=depositBefore-rent;
						if (depositNew>=0) {
							user.setDeposit(depositNew);
						}else {
							user.setDeposit(0.0);
						}
						if (serviceUser.Update(user)>0) {
							if (depositNew>=0) {
								System.out.println("�ӻ�Ա"+user.getUserId()+"���۳����"+rent+"Ԫ");
							}else {
								System.out.println("�ӻ�Ա"+user.getUserId()+"���۳����"+depositBefore+"Ԫ");
								System.out.println("DVD�̵�������"+(0.0-depositNew)+"Ԫ");
							}
							System.out.println("�������"+user.getDeposit()+"Ԫ");
						}else {
							System.out.println("���۳�ʧ��");
						}
						System.out.println("�ѹ黹"+dvdName);
					}
					
				}else {
					System.out.println("�黹DVDʧ��");
				}
			}
		}
		System.out.print("����0���أ�");
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
		System.out.println("������\t  DVD����");
		for (DVD dvd : list) {
			System.out.println("  "+dvd.getLendNum()+"\t"+dvd.getDvdName());
		}
		System.out.print("����0���أ�");
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
		System.out.print("������������Ա������");
		String username=scan.next();
		user.setUserName(username);
		view.showUserType();
		Double deposit;
		do {
			System.out.print("�������Ա��ֵ�Ľ�");
			deposit=tool.nextDouble();
			if (deposit<0) {
				System.out.println("��������");
			}else if (deposit>=0&&deposit<100) {
				System.out.println("�û�������ͨ��Ա");
				user.setUserType(0);
				user.setBorrowNum(0);
				break;
			}else if (deposit>=100&&deposit<200) {
				System.out.println("�û�����ƽ��Ա");
				user.setUserType(1);
				user.setBorrowNum(1);
				break;
			}else if (deposit>=200&&deposit<300) {
				System.out.println("�û��������Ա");
				user.setUserType(2);
				user.setBorrowNum(2);
				break;
			}else if (deposit>=300) {
				System.out.println("�û�������ʯ��Ա");
				user.setUserType(3);
				user.setBorrowNum(5);
				break;
			}
		} while (true);
		user.setDeposit(deposit);
		if(service.Insert(user)>0){
			System.out.println("��Ա"+username+"�����ɹ�");
			System.out.println("��Ա�����ţ���"+service.findOne(user).get(0).getUserId()+"��\n��ʧ����Ŷ");
		}else {
			System.out.println(username+"����ʧ��");
		}
		System.out.print("\n����0���أ�");
		String choice=scan.next();
		if (!"0".equals(choice)) {
			insertUser();
		}
	}
	
}
