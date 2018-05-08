package self.ziv.som.core;
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:48:22 
 * 类说明 :
 * 		負責數據庫鏈接,鏈接池
*/

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import self.ziv.som.bean.Configuration;

public class DBManager {
	private static Configuration conf;
	static {
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sormdb.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setUsername(pros.getProperty("username"));
		conf.setPassword(pros.getProperty("password"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUsingDB(pros.getProperty("usingDB"));

		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setPoPackage(pros.getProperty("poPackage"));
	}

	public static Connection getConn() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (null != rs) {
				rs.close();
			}
			if(null != st) {
				st.close();
			}
			if(null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps, Connection conn) {
		try {
			if (null != ps) {
				ps.close();
			}
			if(null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration getConf() {
		return conf;
	}
	
	public static void main(String[] args) {
		System.out.println(DBManager.getConn());
	}
}
