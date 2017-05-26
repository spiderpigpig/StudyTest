package com.neusoft.bean;

public class City {
	private Integer cityID;
	private String provinceName;
	private String cityName;
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public City(Integer cityID, String provinceName, String cityName) {
		super();
		this.cityID = cityID;
		this.provinceName = provinceName;
		this.cityName = cityName;
	}
	public City() {
		super();
	}
	
}
