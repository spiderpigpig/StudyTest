package com.spider.bean;

import java.sql.Date;

public class DVD {

	private Integer dvdId;
	private String dvdName;
	private Integer lendState;
	private Date lendDate;
	private Double dvdPrice;
	private Integer lendNum;
	
	public Integer getDvdId() {
		return dvdId;
	}
	public void setDvdId(Integer dvdId) {
		this.dvdId = dvdId;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public Integer getLendState() {
		return lendState;
	}
	public void setLendState(Integer lendState) {
		this.lendState = lendState;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Double getDvdPrice() {
		return dvdPrice;
	}
	public void setDvdPrice(Double dvdPrice) {
		this.dvdPrice = dvdPrice;
	}
	public Integer getLendNum() {
		return lendNum;
	}
	public void setLendNum(Integer lendNum) {
		this.lendNum = lendNum;
	}

	
	public DVD(Integer dvdId, String dvdName, Integer lendState, Date lendDate, Double dvdPrice, Integer lendNum) {
		super();
		this.dvdId = dvdId;
		this.dvdName = dvdName;
		this.lendState = lendState;
		this.lendDate = lendDate;
		this.dvdPrice = dvdPrice;
		this.lendNum = lendNum;
	}
	
	public DVD() {
		
	}
	
	public String toString() {
		String lendStatesString="������Ϣ",lendDateString="������Ϣ";
		if (lendState==1) {
			lendStatesString="�ɽ�";
		}else if (lendState==-1) {
			lendStatesString="���¼�";
		}else {
			lendStatesString="�ѽ��";
		}
		
		if (lendDate==null) {
			lendDateString="δ���\t";
		}else {
			lendDateString=lendDate.toString();
		}
		
		if (dvdName.length()<6) {
			dvdName=dvdName+"\t";
		}
		
		return dvdId + "\t" + dvdName + "\t" + lendStatesString + "\t" + lendDateString + "\t" + dvdPrice;
	}

	

	
	
	

}