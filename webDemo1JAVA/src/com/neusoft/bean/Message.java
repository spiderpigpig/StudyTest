package com.neusoft.bean;

import java.util.Date;

public class Message {
	private Integer messageid;
	private Date messageDate;
	private String username;
	private String telephone;
	private String email;
	private String address;
	private String message;
	
	public Integer getMessageid() {
		return messageid;
	}
	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Message(String username, String telephone, String email, String address, String message) {
		super();
		this.username = username;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.message = message;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [messageid=" + messageid + ", messageDate=" + messageDate + ", username=" + username
				+ ", telephone=" + telephone + ", email=" + email + ", address=" + address + ", message=" + message
				+ "]";
	}
	
}
