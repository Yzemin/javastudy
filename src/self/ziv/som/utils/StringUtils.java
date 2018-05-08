package self.ziv.som.utils; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:49:55 
 * 类说明 :
 * 		封裝字符串操作
*/
public class StringUtils {
	/**
	 * 將字符串首字母大寫
	 * @param str
	 * @return
	 */
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0, 1) + str.substring(1);
	}
}
 