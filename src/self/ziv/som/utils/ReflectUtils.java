package self.ziv.som.utils;

import java.lang.reflect.Method;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:50:31 
 * 类说明 :
 * 		反射
*/
public class ReflectUtils {
	/**
	 * 調用obj對象的get方法
	 * @param clazz 
	 * @param fieldName 對應shuxing 
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		Method m;
		try {
			m = obj.getClass().getMethod("get" + StringUtils.firstChar2UpperCase(fieldName));
			return	m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object invokeSet(String fieldName,Object columnValue, Object obj) {
		Method m;
		try {
			m = obj.getClass().getMethod(
					"set" + StringUtils.firstChar2UpperCase(fieldName),
					columnValue.getClass());
			return	m.invoke(obj,columnValue);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
 