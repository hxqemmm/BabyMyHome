package com.ht.bean;

public class Details {
	private int id;
	/**
	 * 发布人
	 * */
	private String issuer;
	/**
	 * 审核
	 * */
	private String audit;
	private String times;
	private String name;
	private String sex;
	/**
	 * 出生时间
	 * */
	private String birthday;
	/**
	 * 失踪时间
	 * */
	private String missday;
	/**
	 * 与失踪人关系
	 * */
	private String relation;
	/**
	 * 失踪人籍贯
	 * */
	private String natives;
	/**
	 * 失踪地点
	 * */
	private String place;
	/**
	 * 失踪人特征
	 * */
	private String feature;
	/**
	 * 失踪人照片
	 * */
	private String photo;
	/**
	 * 失踪经过
	 * */
	private String pass;
	/**
	 * 补充说明
	 * */
	private String replenish;
	/**
	 * 是否找回
	 * */
	private String state;
	/**
	 * 标题
	 * */
	private String headline;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMissday() {
		return missday;
	}
	public void setMissday(String missday) {
		this.missday = missday;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getNatives() {
		return natives;
	}
	public void setNatives(String natives) {
		this.natives = natives;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReplenish() {
			return replenish;
		}
	public void setReplenish(String replenish) {
		this.replenish = replenish;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	

}
