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
		// 1. 获取连接
		conn = JDBCUtil.getConnection();
		// 2. 写SQL语句
		String sql = "select id,name,description,status,createTime,price from fund";
		// 3.创建PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4.发送执行sql语句，得到结果集
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
		// 1. 获取连接
		conn = JDBCUtil.getConnection();
		// 2. 写SQL语句
		String sql = "insert into fund (name,description,price,status,createTime) value(?,?,?,?,?)";
		// 3. 创建PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. 给sql变量赋值
			// pstmt.setInt(1,fund.getId());
			pstmt.setString(1, fund.getName());
			pstmt.setString(2, fund.getDescription());
			pstmt.setDouble(3, fund.getPrice());
			pstmt.setString(4, fund.getStatus());
			java.sql.Date date = new java.sql.Date(fund.getCreateTime().getTime());
			pstmt.setDate(5, date);
			// 5 .发送执行sql语句，得到结果集
			int rus = pstmt.executeUpdate();
			// 6. 对结果集遍历
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. 关闭连接对象等
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void delete(int fundNo) {
		// TODO Auto-generated method stub
		Fund fund = null;
		// 1. 获取连接
		conn = JDBCUtil.getConnection();
		// 2.写SQL语句
		String sql = "delete from fund where id=?";
		// 3. 创建PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. 给sql变量赋值
			pstmt.setInt(1, fundNo);
			// 5 .发送执行sql语句，得到结果集
			int rus = pstmt.executeUpdate();
			// 6. 对结果集遍历
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. 关闭连接对象等
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void update(Fund fund) {
		// TODO Auto-generated method stub
		// 1. 获取连接
		conn = JDBCUtil.getConnection();
		// 2.写sql语句
		String sql="update fund set name=?,price=?,"
				+ "description=?,status=? where id=?";
		// 3.创建 PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4.给sql变量赋值
			pstmt.setString(1, fund.getName());
			pstmt.setDouble(2, fund.getPrice());
			pstmt.setString(3,fund.getDescription());
			pstmt.setString(4, fund.getStatus());
			pstmt.setInt(5, fund.getId());
			// 5.发送执行SQL语句，得到结果集
			pstmt.executeUpdate();
			// 6.对结果集遍历
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7. 关闭连接对象等
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public Fund findById(int fundNo) {
		// TODO Auto-generated method stub
		Fund fund = null;
		// 1. 获取连接
		conn = JDBCUtil.getConnection();
		// 2. 写SQL语句
		String sql = "select * from fund where id=?";
		// 3. 创建PreparedStatment
		try {
			pstmt = conn.prepareStatement(sql);
			// 4. 给sql变量赋值
			pstmt.setInt(1, fundNo);
			// 5 .发送执行sql语句，得到结果集
			rs = pstmt.executeQuery();
			// 6. 对结果集遍历
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
			// 7. 关闭连接对象等
			JDBCUtil.close(rs, pstmt, conn);
		}
		return fund;
	}

}
