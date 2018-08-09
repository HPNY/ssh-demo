package com.mybank.fundtrans.domain;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private String password;
	private Date createTime;
	private String realName;
	public User() {
		super();
	}
	public User(Integer id, String name, String password, Date createTime, String realName) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.createTime = createTime;
		this.realName = realName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
