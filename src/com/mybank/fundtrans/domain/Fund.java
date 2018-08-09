package com.mybank.fundtrans.domain;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name="fund")
public class Fund {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;    //id, 自增长
	@Column(name="name",unique=true,nullable=false)
	private String  name;  //名字
	private Double  price;  //价格
	private String  description; //描述
	private String  status;  //状态，Y-可用，N-不可用
	private Date    createTime;  //创建日期
	//private String company;
	
	public Fund(Integer id, String name, Double price, String description, String status, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.status = status;
		this.createTime = createTime;
	}
	public Fund() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", createTime=" + createTime + ", price=" + price + "]";
	}
	
}
