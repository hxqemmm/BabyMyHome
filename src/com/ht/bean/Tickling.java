package com.ht.bean;

public class Tickling {
	private int ID;
	private String name;
	/**
	 * 联系方式
	 * */
	private String contact;
	/**
	 * 内容
	 * */
	private String ticklings;
	private String date;
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTicklings() {
		return ticklings;
	}
	public void setTicklings(String ticklings) {
		this.ticklings = ticklings;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
