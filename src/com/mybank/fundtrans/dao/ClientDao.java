package com.mybank.fundtrans.dao;
import java.util.List;
import com.mybank.fundtrans.domain.Client;

public interface ClientDao {
	List<Client> findAll();    //获取所有的基金记录,返回Fund对象列表
	void insert(Client client);    //插入一条基金记录
	void delete(String idCard);    //按主键删除一条基金记录
	void update(Client client);    //更新一条基金记录
	Client findById(String idCard);  //按主键查找基金记录，返回Fund对象
}
