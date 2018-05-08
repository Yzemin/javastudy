package self.ziv.som.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import self.ziv.som.bean.ColumnInfo;
import self.ziv.som.bean.TableInfo;
import self.ziv.som.utils.JDBCUtilse;
import self.ziv.som.utils.ReflectUtils;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月16日   下午8:21:26 
 * 类说明 :
 * 
*/
public class MysqlQuery implements Query {
	/**
	 * 直接執行一個DML
	 * @param sql sql語句
	 * @param params 參數
	 * @return 受影響的行數,int
	 */
	@Override
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		PreparedStatement ps = null;
		int count = 0;
		try {
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			JDBCUtilse.handleParams(ps, params);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return count;
	}
	/**
	 * 將一個對象存儲到數據庫中
	 * @param obj 要存儲的對象
	 */
	@Override
	public void insert(Object obj) {
		Class clazz = obj.getClass();
		TableInfo tableInfo = TableContext.getPoClassTableMap().get(clazz);
		StringBuilder sql = new StringBuilder();
		sql.append("insert into ").append(tableInfo.getTname()).append(" (");
		Field[] fs = clazz.getDeclaredFields();
		List<Object> params = new ArrayList<Object>();
		int countNotNullField = 0;
		for (Field field : fs) {
			String fieldName = field.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			if(fieldName != null) {
				countNotNullField ++;
				sql.append(fieldName).append(",");
				params.add(fieldValue);
			}
		}
		sql.setCharAt(sql.length() - 1, ')');
		sql.append(" values (");
		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length() - 1, ')');
		executeDML(sql.toString(), params.toArray());
	}
	/**
	 * 刪除一個對像
	 * @param clazz 更表對應的類
	 * @param id 主鍵id
	 * @return 受影響的行數,int
	 */
	@Override
	public int delete(Class clazz, Object id) {
		TableInfo tableInfo = TableContext.getPoClassTableMap().get(clazz);
		ColumnInfo onlyPrikey = tableInfo.getOnlyPrikey();
		
		String sql = "delete from " + tableInfo.getTname() + 
				" where " + onlyPrikey.getName() + "=?;";
		return executeDML(sql, new Object[] {id});
	}
	/**
	 * 刪除數據庫中的對應的值
	 * @param obj 對象
	 * @return 受影響的行數,int
	 */
	@Override
	public int delete(Object obj) {
		Class clazz = obj.getClass();
		TableInfo tableInfo = TableContext.getPoClassTableMap().get(clazz);
		ColumnInfo onlyPrikey = tableInfo.getOnlyPrikey();
		Object priKeyValue = ReflectUtils.invokeGet(onlyPrikey.getName(), obj);
		return delete(clazz,priKeyValue);
	}
	/**
	 * 更新對象對應的記錄
	 * @param obj 要更改的對象
	 * @param fieldNames 更新的屬性列表
	 * @return 受影響的行數,int
	 */
	@Override
	public int update(Object obj, String[] fieldNames) {
		Class c = obj.getClass();
		ArrayList<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.getPoClassTableMap().get(c);
		ColumnInfo prikey = tableInfo.getOnlyPrikey();
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");
		
		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname +"=?,");
		}
		sql.setCharAt(sql.length() -1, ' ');
		sql.append(" where ");
		sql.append(prikey.getName() + "=? ");
		params.add(ReflectUtils.invokeGet(prikey.getName(), obj));
		return executeDML(sql.toString(), params.toArray());
	}
	/**
	 * 查詢放回多行記錄，將值封裝到對應的對象中
	 * @param sql 查詢語句
	 * @param clazz 返回結構的對象
	 * @param params 查詢條件
	 * @return 查詢的多行結構
	 */
	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		Connection conn = DBManager.getConn();
		int count = 0;
		List list = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		ResultSetMetaData metaData = null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtilse.handleParams(ps, params);
			System.out.println(sql);
			rs = ps.executeQuery();
			metaData = rs.getMetaData();
			while(rs.next()) {
				if(list == null) {
					list = new ArrayList();
				}
				Object rowObj = clazz.newInstance();
				for(int i=0;i<metaData.getColumnCount();i++) {
					String columnName = metaData.getColumnName(i + 1);
					Object columnValue = rs.getObject(i+1);
					ReflectUtils.invokeSet(columnName, columnValue, rowObj);
				}
				list.add(rowObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return list;
	}
	/**
	 * 查詢放回一行記錄，將值封裝到對應的對象中
	 * @param sql 查詢語句
	 * @param clazz 返回結構的對象
	 * @param params 查詢條件
	 * @return 查詢的一行結構,對應的對象
	 */
	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql,clazz,params);
		return (list==null&&list.size()>0)?null:list.get(0);
	}
	/**
	 * 查詢返回一個值
	 * @param sql 查詢語句
	 * @param params 查詢參數
	 * @return 查詢的一行結構
	 */
	@Override
	public Object queryValue(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		Object value = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtilse.handleParams(ps, params);
			System.out.println(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				value = rs.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		return value;
	}
	/**
	 * 查詢返回一個值
	 * @param sql 查詢語句
	 * @param params 查詢參數
	 * @return 返回一個數字
	 */
	@Override
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}
	
}
 