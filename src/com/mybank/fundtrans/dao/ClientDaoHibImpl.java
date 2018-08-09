package com.mybank.fundtrans.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mybank.fundtrans.domain.Client;
import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;

public class ClientDaoHibImpl implements ClientDao {
	
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		List<Client> clients=new ArrayList<Client>();
		try {
			Session session=HibernateUtil.getSession();
			session.beginTransaction();
			String hql="FROM Client client";
			Query query=session.createQuery(hql);
			clients=query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return clients;
	}

	@Override
	public void insert(Client client) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			session.save(client);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void delete(String idCard) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Client client=(Client) session.get(Client.class, idCard);
			session.delete(client);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			client.setCreateTime(new Date());
			session.update(client);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public Client findById(String idCard) {
		// TODO Auto-generated method stub
		Client client = null;
		try {
			Session session=HibernateUtil.getSession();
			client=(Client) session.get(Client.class, idCard);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return client;
	}

}
