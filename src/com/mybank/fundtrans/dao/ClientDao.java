package com.mybank.fundtrans.dao;
import java.util.List;
import com.mybank.fundtrans.domain.Client;

public interface ClientDao {
	List<Client> findAll();    //��ȡ���еĻ����¼,����Fund�����б�
	void insert(Client client);    //����һ�������¼
	void delete(String idCard);    //������ɾ��һ�������¼
	void update(Client client);    //����һ�������¼
	Client findById(String idCard);  //���������һ����¼������Fund����
}
