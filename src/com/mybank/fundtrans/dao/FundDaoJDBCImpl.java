package com.mybank.fundtrans.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;

import com.mybank.fundtrans.domain.Fund;
import com.mybank.fundtrans.util.JDBCUtil;

public class FundDaoJDBCImpl implements FundDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<Fund> findAll() {
		// TODO Auto-generated method stub
		List<Fund> result = new ArrayList<Fund>();
		// 1. ��ȡ����
		conn = JDBCUtil.getConnection();
		// 2. дSQL���
		String sql = "select id,name,description,status,createTime,price from fund";
		// 3.����PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4.����ִ��sql��䣬�õ������
			rs = pstmt.executeQuery();
			Fund f = null;
			while (rs.next()) {
				f = new Fund();
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				f.setDescription(rs.getString("description"));
				f.setStatus(rs.getString("status"));
				f.setCreateTime(rs.getDate("createTime"));
				f.setPrice(rs.getDouble("price"));
				result.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Fund fund) {
		// TODO Auto-generated method stub
		// 1. ��ȡ����
		conn = JDBCUtil.getConnection();
		// 2. дSQL���
		String sql = "insert into fund (name,description,price,status,createTime) value(?,?,?,?,?)";
		// 3. ����PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. ��sql������ֵ
			// pstmt.setInt(1,fund.getId());
			pstmt.setString(1, fund.getName());
			pstmt.setString(2, fund.getDescription());
			pstmt.setDouble(3, fund.getPrice());
			pstmt.setString(4, fund.getStatus());
			java.sql.Date date = new java.sql.Date(fund.getCreateTime().getTime());
			pstmt.setDate(5, date);
			// 5 .����ִ��sql��䣬�õ������
			int rus = pstmt.executeUpdate();
			// 6. �Խ��������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. �ر����Ӷ����
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void delete(int fundNo) {
		// TODO Auto-generated method stub
		Fund fund = null;
		// 1. ��ȡ����
		conn = JDBCUtil.getConnection();
		// 2.дSQL���
		String sql = "delete from fund where id=?";
		// 3. ����PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. ��sql������ֵ
			pstmt.setInt(1, fundNo);
			// 5 .����ִ��sql��䣬�õ������
			int rus = pstmt.executeUpdate();
			// 6. �Խ��������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. �ر����Ӷ����
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void update(Fund fund) {
		// TODO Auto-generated method stub
		// 1. ��ȡ����
		conn = JDBCUtil.getConnection();
		// 2.дsql���
		String sql="update fund set name=?,price=?,"
				+ "description=?,status=? where id=?";
		// 3.���� PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4.��sql������ֵ
			pstmt.setString(1, fund.getName());
			pstmt.setDouble(2, fund.getPrice());
			pstmt.setString(3,fund.getDescription());
			pstmt.setString(4, fund.getStatus());
			pstmt.setInt(5, fund.getId());
			// 5.����ִ��SQL��䣬�õ������
			pstmt.executeUpdate();
			// 6.�Խ��������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. �ر����Ӷ����
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public Fund findById(int fundNo) {
		// TODO Auto-generated method stub
		Fund fund = null;
		// 1. ��ȡ����
		conn = JDBCUtil.getConnection();
		// 2. дSQL���
		String sql = "select * from fund where id=?";
		// 3. ����PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. ��sql������ֵ
			pstmt.setInt(1, fundNo);
			// 5 .����ִ��sql��䣬�õ������
			rs = pstmt.executeQuery();
			// 6. �Խ��������
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String des = rs.getString("description");
				Double price = rs.getDouble("price");
				String status = rs.getString("status");
				Date createTime = rs.getDate("createTime");
				fund = new Fund();
				fund.setId(id);
				fund.setName(name);
				fund.setDescription(des);
				fund.setPrice(price);
				fund.setStatus(status);
				fund.setCreateTime(createTime);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. �ر����Ӷ����
			JDBCUtil.close(rs, pstmt, conn);
		}
		return fund;
	}

}
