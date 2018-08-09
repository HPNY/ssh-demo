package com.mybank.fundtrans.controller;

import java.util.Date;
import java.util.List;

import com.mybank.fundtrans.dao.FundDao;
import com.mybank.fundtrans.dao.FundDaoHibImpl;
import com.mybank.fundtrans.dao.FundDaoJDBCImpl;
import com.mybank.fundtrans.domain.Fund;
import com.opensymphony.xwork2.ActionSupport;

public class FundAction extends ActionSupport {

	private Fund fund;
	private FundDao funddao=new FundDaoHibImpl();
	private List<Fund> fundlist;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String add() {
		fund.setCreateTime(new Date());
		funddao.insert(fund);
		return SUCCESS;
	}
	
	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public List<Fund> getFundlist() {
		return fundlist;
	}

	public void setFundlist(List<Fund> fundlist) {
		this.fundlist = fundlist;
	}

	public String findAll() {
		fundlist=funddao.findAll();		
		return "showFunds";
	}
	
	public String updateshow() {
		fund=funddao.findById(id);
		return "update";
	}
	
	public String update() {
		funddao.update(fund);
		return SUCCESS;
	}
	
	public String delete() {
		funddao.delete(id);
		return SUCCESS;
	}
	
}
