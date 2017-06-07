package com.spider.bean;

public class DVDUser {

	private Integer userId;
	private String userName;
	private Integer userType;
	private Double deposit;
	private Integer borrowNum;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Integer getBorrowNum() {
		return borrowNum;
	}
	public void setBorrowNum(Integer borrowNum) {
		this.borrowNum = borrowNum;
	}


	public DVDUser(Integer userId, String userName, Integer userType, Double deposit, Integer borrowNum) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.deposit = deposit;
		this.borrowNum = borrowNum;
	}


	public DVDUser() {

	}
	
	public String toString() {
		String userTypeString = "信息错误";
		switch (userType) {
		case 0:
			userTypeString="非会员";
			break;
		case 1:
			userTypeString="金卡会员";
			break;
		case 2:
			userTypeString="铂金卡会员";
			break;
		case 3:
			userTypeString="钻石卡会员";
			break;
		}
		
		return userId + "\t" + userName + "\t" + userTypeString + "\t" + deposit + "\t" + borrowNum;
	}
	
	

	
	
	

}