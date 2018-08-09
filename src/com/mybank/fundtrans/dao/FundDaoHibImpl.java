package com.mybank.fundtrans.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.HibernateUtil;

public class FundDaoHibImpl implements FundDao {

	@Override
	public List<Fund> findAll() {
		// TODO Auto-generated method stub
		List<Fund> funds=new ArrayList<Fund>();
		try {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		String hql="FROM Fund fund";
		Query query=session.createQuery(hql);
		funds=query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return funds;
	}

	@Override
	public void insert(Fund fund) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			session.save(fund);
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
	public void delete(int fundNo) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Fund fund=(Fund) session.get(Fund.class, fundNo);
			session.delete(fund);
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
	public void update(Fund fund) {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			fund.setCreateTime(new Date());
			session.update(fund);
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
	public Fund findById(int fundNo) {
		// TODO Auto-generated method stub
		Fund fund = null;
		try {
			Session session=HibernateUtil.getSession();
			fund=(Fund) session.get(Fund.class, fundNo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return fund;
	}

}
