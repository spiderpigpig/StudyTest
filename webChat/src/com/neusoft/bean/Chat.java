package com.neusoft.bean;

import java.util.Date;

public class Chat {
	private Integer chatID;
	private String username;
	private String talkContent;
	private Date talkDate;
	public Integer getChatID() {
		return chatID;
	}
	public void setChatID(Integer chatID) {
		this.chatID = chatID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTalkContent() {
		return talkContent;
	}
	public void setTalkContent(String talkContent) {
		this.talkContent = talkContent;
	}
	public Date getTalkDate() {
		return talkDate;
	}
	public void setTalkDate(Date talkDate) {
		this.talkDate = talkDate;
	}
	public Chat() {
		super();
	}
	public Chat(Integer chatID, String username, String talkContent, Date talkDate) {
		super();
		this.chatID = chatID;
		this.username = username;
		this.talkContent = talkContent;
		this.talkDate = talkDate;
	}
	@Override
	public String toString() {
		return "Chat [chatID=" + chatID + ", username=" + username + ", talkContent=" + talkContent + ", talkDate="
				+ talkDate + "]";
	}
	
}
