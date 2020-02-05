package com.example.hp.domian;

public class House {
	private int id;
	private String name;
	private int price;
	private double area;
	private String floor;
	private String village;
	private String houseType;
	private String address;
	private String subway;
	private String pTime;
	private String ori;
	private String bulidTime;
	private String rentType;
	private String image;
	private Agent agent;
	
	public House(int id, String name, int price, double area, String floor, String village, String houseType,
			String address, String subway, String pTime, String ori, String bulidTime, String rentType, String image,
			Agent agent) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.village = village;
		this.houseType = houseType;
		this.address = address;
		this.subway = subway;
		this.pTime = pTime;
		this.ori = ori;
		this.bulidTime = bulidTime;
		this.rentType = rentType;
		this.image = image;
		this.agent = agent;
	}
	public House(String name, int price, double area, String floor, String village, String houseType, String address,
			String subway, String pTime, String ori, String bulidTime, String rentType, String image, Agent agent) {
		super();
		this.name = name;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.village = village;
		this.houseType = houseType;
		this.address = address;
		this.subway = subway;
		this.pTime = pTime;
		this.ori = ori;
		this.bulidTime = bulidTime;
		this.rentType = rentType;
		this.image = image;
		this.agent = agent;
	}
	
	public House() {
		super();
	}
	public House(String name, int price, double area, String floor, String village, String houseType, String address,
			String subway, String pTime, String ori, String bulidTime, String rentType, String image) {
		super();
		this.name = name;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.village = village;
		this.houseType = houseType;
		this.address = address;
		this.subway = subway;
		this.pTime = pTime;
		this.ori = ori;
		this.bulidTime = bulidTime;
		this.rentType = rentType;
		this.image = image;
	}
	
   
	public House(int id, String name, int price, double area, String floor, String village, String houseType,
			String address, String subway, String pTime, String ori, String bulidTime, String rentType, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.area = area;
		this.floor = floor;
		this.village = village;
		this.houseType = houseType;
		this.address = address;
		this.subway = subway;
		this.pTime = pTime;
		this.ori = ori;
		this.bulidTime = bulidTime;
		this.rentType = rentType;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubway() {
		return subway;
	}
	public void setSubway(String subway) {
		this.subway = subway;
	}
	public String getpTime() {
		return pTime;
	}
	public void setpTime(String pTime) {
		this.pTime = pTime;
	}
	public String getOri() {
		return ori;
	}
	public void setOri(String ori) {
		this.ori = ori;
	}
	public String getBulidTime() {
		return bulidTime;
	}
	public void setBulidTime(String bulidTime) {
		this.bulidTime = bulidTime;
	}
	public String getRentType() {
		return rentType;
	}
	public void setRentType(String rentType) {
		this.rentType = rentType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + name + ", price=" + price + ", area=" + area + ", floor=" + floor
				+ ", village=" + village + ", houseType=" + houseType + ", address=" + address + ", subway=" + subway
				+ ", pTime=" + pTime + ", ori=" + ori + ", bulidTime=" + bulidTime + ", rentType=" + rentType
				+ ", image=" + image + ", agent=" + agent + "]";
	}
	
	
	
	

}
