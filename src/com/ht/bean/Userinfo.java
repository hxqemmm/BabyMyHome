package com.ht.bean;

public class Userinfo {
	private int id;
	private String phone;
	/**
	 * 用户名（昵称）
	 * */
	private String username;
	private String password;
	/**
	 * 头像
	 * */
	private String headimage;
	/**
	 * 籍贯
	 * */
	private String natives;	
	private String sex;
	private int age;
	private String QQ;
	/**
	 * 个性签名
	 * */
	private String sdasd;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getHeadimage() {
		return headimage;
	}
	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}
	public String getNatives() {
		return natives;
	}
	public void setNatives(String natives) {
		this.natives = natives;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qq) {
		QQ = qq;
	}
	public String getSdasd() {
		return sdasd;
	}
	public void setSdasd(String sdasd) {
		this.sdasd = sdasd;
	}
	
}
