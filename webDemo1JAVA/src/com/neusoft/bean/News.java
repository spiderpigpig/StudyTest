package com.neusoft.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
	private Integer newsID;
	private Date newsDate;
	private String title;
	private String newsContent;
	private String newsDateStr;
	public String getNewsDateStr(){
		return newsDateStr;
	}
	public Integer getNewsID() {
		return newsID;
	}
	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
		this.newsDateStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newsDate);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public News(String title, String newsContent) {
		super();
		this.title = title;
		this.newsContent = newsContent;
	}
	public News() {
		super();
	}
	@Override
	public String toString() {
		return "News [newsID=" + newsID + ", newsDate=" + newsDate + ", title=" + title + ", newsContent=" + newsContent
				+ "]";
	}
	
}
