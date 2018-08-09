package com.mybank.fundtrans.dao;
import java.util.List;
import com.mybank.fundtrans.domain.Fund;

public interface FundDao {
	List<Fund> findAll();    //��ȡ���еĻ����¼,����Fund�����б�
	void insert(Fund fund);    //����һ�������¼
	void delete(int fundNo);    //������ɾ��һ�������¼
	void update(Fund fund);    //����һ�������¼
	Fund findById(int fundNo);  //���������һ����¼������Fund����
}
