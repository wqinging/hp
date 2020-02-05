package com.example.hp.domian;

public class PubHouse {
	private int id;
	private String userPhone;
	private String city;
	private String area;
	private String build;
	private String unit;
	private String signum;
	private String price;
	public PubHouse(int id, String userPhone, String city, String area, String build, String unit, String signum,
			String price) {
		super();
		this.id = id;
		this.userPhone = userPhone;
		this.city = city;
		this.area = area;
		this.build = build;
		this.unit = unit;
		this.signum = signum;
		this.price = price;
	}
	public PubHouse(String userPhone, String city, String area, String build, String unit, String signum,
			String price) {
		super();
		this.userPhone = userPhone;
		this.city = city;
		this.area = area;
		this.build = build;
		this.unit = unit;
		this.signum = signum;
		this.price = price;
	}
	public PubHouse(String userPhone, String area, String build, String unit, String signum, String price) {
		super();
		this.userPhone = userPhone;
		this.area = area;
		this.build = build;
		this.unit = unit;
		this.signum = signum;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSignum() {
		return signum;
	}
	public void setSignum(String signum) {
		this.signum = signum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "PubHouse [id=" + id + ", userPhone=" + userPhone + ", city=" + city + ", area=" + area + ", build="
				+ build + ", unit=" + unit + ", signum=" + signum + ", price=" + price + "]";
	}
	
	
}
