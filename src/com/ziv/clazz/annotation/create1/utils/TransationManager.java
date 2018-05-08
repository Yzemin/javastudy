package com.ziv.clazz.annotation.create1.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import self.ziv.som.core.DBManager;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月21日   上午11:32:15 
 * 类说明 :
 * 
*/
public class TransationManager {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection conn = tl.get();// 从当前线程上获得链接
        if (conn == null) {
            conn = DBManager.getConn();
            tl.set(conn);// 把链接绑定到当前线程上
        }
        return conn;
    }

    public static void startTransaction() {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        Connection conn = getConnection();
        try {
        	if(conn != null)
        		conn.close();
            tl.remove();// 与线程池有关，解除关系
        } catch (SQLException e) {
            e.printStackTrace();
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
			tl.remove();
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
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
