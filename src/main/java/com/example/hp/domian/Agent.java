package com.example.hp.domian;

public class Agent {
	private int id;
	private String name;
	private String phoneNumber;
	private String image;

	public Agent() {
		super();
	}

	public Agent(int id) {
		super();
		this.id = id;
	}

	public Agent(int id, String name, String phoneNumber, String image) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", image=" + image + "]";
	}

}
