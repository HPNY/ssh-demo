package com.mybank.fundtrans.controller;

import java.util.Date;
import java.util.List;

import com.mybank.fundtrans.dao.ClientDao;
import com.mybank.fundtrans.dao.ClientDaoHibImpl;
import com.mybank.fundtrans.domain.Client;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport {
	private Client client;
	private ClientDao clientdao=new ClientDaoHibImpl();
	private List<Client> clientlist;
	private String idCard;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getClientlist() {
		return clientlist;
	}
	public void setClientlist(List<Client> clientlist) {
		this.clientlist = clientlist;
	}

	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String add() {
		client.setCreateTime(new Date());
		clientdao.insert(client);
		return SUCCESS;
	}
	public String findAll() {
		clientlist=clientdao.findAll();
		return "showClients";
	}
	public String updateshow() {
		client=clientdao.findById(idCard);
		return "update";
	}
	public String update() {
		clientdao.update(client);
		return SUCCESS;
	}
	public String delete() {
		clientdao.delete(idCard);
		return SUCCESS;
	}
}
