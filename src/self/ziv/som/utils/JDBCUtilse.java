package self.ziv.som.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:49:03 
 * 类说明 :
 * 		封裝jdbc查詢常用操作
*/
public class JDBCUtilse {
	public static void handleParams(PreparedStatement ps, Object[] params) {
		if(params != null) {
			try {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(1 + i, params[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
 