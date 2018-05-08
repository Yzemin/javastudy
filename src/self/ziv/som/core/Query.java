package self.ziv.som.core;

import java.util.List;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:23:15 
 * 类说明 :
 *		負責查詢(對外提供服務) 
*/
@SuppressWarnings("rawtypes")
public interface Query {
	/**
	 * 直接執行一個DML
	 * @param sql sql語句
	 * @param params 參數
	 * @return 受影響的行數,int
	 */
	public int executeDML(String sql,Object[] params);
	
	/**
	 * 將一個對象存儲到數據庫中
	 * @param obj 要存儲的對象
	 */
	public void insert(Object obj);
	
	/**
	 * 刪除一個對像
	 * @param clazz 更表對應的類
	 * @param id 主鍵id
	 * @return 受影響的行數,int
	 */
	public int delete(Class clazz,Object id);
	
	/**
	 * 刪除數據庫中的對應的值
	 * @param obj 對象
	 * @return 受影響的行數,int
	 */
	public int delete(Object obj);
	
	/**
	 * 更新對象對應的記錄
	 * @param obj 要更改的對象
	 * @param fieldNames 更新的屬性列表
	 * @return 受影響的行數,int
	 */
	public int update(Object obj,String[] fieldNames);
	
	/**
	 * 查詢放回多行記錄，將值封裝到對應的對象中
	 * @param sql 查詢語句
	 * @param clazz 返回結構的對象
	 * @param params 查詢條件
	 * @return 查詢的多行結構
	 */
	public List queryRows(String sql,Class clazz,Object[] params);
	
	/**
	 * 查詢放回一行記錄，將值封裝到對應的對象中
	 * @param sql 查詢語句
	 * @param clazz 返回結構的對象
	 * @param params 查詢條件
	 * @return 查詢的一行結構,對應的對象
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);
	
	/**
	 * 查詢返回一個值
	 * @param sql 查詢語句
	 * @param params 查詢參數
	 * @return 查詢的一行結構
	 */
	public Object queryValue(String sql,Object[] params);
	
	/**
	 * 查詢返回一個值
	 * @param sql 查詢語句
	 * @param params 查詢參數
	 * @return 返回一個數字
	 */
	public Number queryNumber(String sql,Object[] params);
}