package com.ziv.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ziv.prop.PropertiesUtil;

public class ConnectionFactory {
	private static Connection conn = null;
	/*	get jdbc connection params	*/
	static{
		getConnection(PropertiesUtil.getProperty("jdbc.driver"),PropertiesUtil.getProperty("jdbc.database"),
				PropertiesUtil.getProperty("jdbc.username"),PropertiesUtil.getProperty("jdbc.userpwd"));
	}
	/**
	 * jdbc connection get init Object
	 * @return Statement
	 * @throws SQLException
	 */
	public static Statement getConnectionFactory() throws SQLException{
		return conn.createStatement();
	}
	public static Connection getConn() throws SQLException{
		return conn;
	}
	/**
	 * init jdbc connection
	 * @param driverJdbc
	 * @param urlJdbc
	 * @param usernameJdbc
	 * @param userpasswordJdbc
	 */
	private static void getConnection(String driverJdbc, String urlJdbc,
			String usernameJdbc,String userpasswordJdbc){
		try {
			Class.forName(driverJdbc);
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(urlJdbc, usernameJdbc, userpasswordJdbc);
		} catch (SQLException e) {
			System.out.println("Database connection is fail !");
//			e.printStackTrace();
		}
	}
	/**
	 * close cnnection jdbc
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void close(Connection conn, Statement stat,ResultSet rs){
		try {
			if(conn != null){
				conn.close();
			}
			if(stat != null){
				stat.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("close connection is fail !");
//			e.printStackTrace();
		}
	}
	/**
	 * close jdbc cnnection
	 * @param stat
	 * @param rs
	 */
	public static void close(Statement stat,ResultSet rs){
		try {
			if(conn != null){
				conn.close();
			}
			if(stat != null){
				stat.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("close connection is fail !");
//			e.printStackTrace();
		}
	}
	/**
	 * @param conn2
	 * @param ps
	 */
	private static void close(Connection conn, PreparedStatement ps) {
		try {
			if(conn != null){
				conn.close();
			}
			if(ps != null){
				ps.close();
			}
		} catch (Exception e) {
			System.out.println("close connection is fail !");
//			e.printStackTrace();
		}
	}
	
	@Test
	public void selectTest() {
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = ConnectionFactory.getConnectionFactory();
			System.out.println("JDBC-STATEMENT:"+stat);
			rs = stat.executeQuery("SELECT * FROM users");
			while(rs.next()){
				System.out.println(rs.getString("username"));
			}
		} catch (SQLException e) {
//			e.printStackTrace();
		}finally{
			ConnectionFactory.close(stat, rs);
		}
	}
	
	@Test
	public void updateTest2() {		
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			conn = ConnectionFactory.getConn();
			ps = conn.prepareStatement("update users set password=? where username=?");
			ps.setString(1, "123");
			ps.setString(2, "张晓明");
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps);
		}
		System.out.println(rows);
	}
	
	@Test
	public void updateTest() {
		Statement stat = null;
		int rows = 0;
		try {
			stat = ConnectionFactory.getConnectionFactory();
			System.out.println("JDBC-STATEMENT:"+stat);
			rows = stat.executeUpdate("update users set password='123' where powers=0");
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(stat, null);
		}
	}
}
