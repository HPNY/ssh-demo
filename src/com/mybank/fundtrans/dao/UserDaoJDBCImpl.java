package com.mybank.fundtrans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mybank.fundtrans.domain.User;
import com.mybank.fundtrans.util.JDBCUtil;

public class UserDaoJDBCImpl implements UserDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public User login(String name, String password) {
		User user = null;
		conn = JDBCUtil.getConnection();
		String sql = "select * from user where name=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setCreateTime(rs.getDate("createTime"));
				user.setRealName(rs.getString("realName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
}
