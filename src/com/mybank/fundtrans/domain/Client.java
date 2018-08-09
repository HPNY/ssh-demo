package com.mybank.fundtrans.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="client")
public class Client {
	@Id
	@GenericGenerator(name="assigned",strategy="assigned")
	@GeneratedValue(generator="assigned")
	private String idCard; // 客户身份证号
	private String name; // 客户姓名
	private String sex; // 客户性别
	private String phone; // 客户联系电话
	private String address; // 客户地址
	private String email; // 客户电邮
	private String hobby; // 客户爱好
	private Date createTime; // 客户创建时间
	/*
	//一对一 FinAcc
	@OneToOne(targetEntity=FinAcc.class,mappedBy="client")
	@Cascade(CascadeType.ALL)
	private FinAcc finAcc;
	*/
	
	public String getIdCard() {
		return idCard;
	}
	public Client() {
		super();
	}
	public Client(String idCard, String name, String sex, String phone, String address, String email, String hobby,
			Date createTime) {
		super();
		this.idCard = idCard;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.hobby = hobby;
		this.createTime = createTime;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/*
	public FinAcc getFinAcc() {
		return finAcc;
	}
	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}
	*/
}
