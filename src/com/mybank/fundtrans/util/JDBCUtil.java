package com.mybank.fundtrans.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
* Description: TODO
* @author 
* @date 2017��2��25�� ����2:37:05
 */
public class JDBCUtil {
	private static final String CONNURL = "jdbc:mysql://localhost:3306/fundtransdb?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	/*ʹ�þ�̬�������������ļ���*/
	static {
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*�ṩ���ӵķ���*/
	public static Connection getConnection() {
		Connection con = null;
		try {
			//����ָ����MMySQL���ݿ⣬���������ֱ��ǣ����ݿ��ַ���˺š�����
			con = DriverManager.getConnection(CONNURL,USERNAME , PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	/*�ر����ӵķ���*/
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
