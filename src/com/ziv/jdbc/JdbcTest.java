package com.ziv.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ziv.jdbc.ConnectionFactory;

public class JdbcTest {
	
	@Test
	public void jdbcTest(){
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = ConnectionFactory.getConnectionFactory();
			rs = stat.executeQuery("SELECT * FROM user");
			System.out.println(stat);
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(stat, rs);
		}
	}
	
}
