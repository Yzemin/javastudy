package com.ziv.clazz.annotation.create1.query;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ziv.clazz.annotation.create1.utils.TransationManager;
import com.ziv.jdbc.ConnectionFactory;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月21日   上午11:43:43 
 * 类说明 :
 * 
*/
public class Query {
	public int update (String sql) throws SQLException {
		Statement stat = ConnectionFactory.getConnectionFactory();
		int rows = stat.executeUpdate(sql);
		stat.close();
		return rows;
	}
	@Test
	public void updateTest() throws SQLException {
		System.out.println(
				new Query().update("update users set password='1234' where powers=0"));
	}
}
 