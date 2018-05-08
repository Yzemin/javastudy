package self.ziv.som.core; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:42:17 
 * 类说明 :
 * 		負責java 數據類型與sql 數據類型之間的轉換
*/
public interface TypeConvertor {
	/**
	 * 將數據庫類型轉爲java數據類型
	 * @param columnType 數據庫字段類型
	 * @return java數據類型
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * 將java數據類型轉爲數據庫數據類型
	 * @param javaDataType java數據類型
	 * @return 數據庫數據類型
	 */
	public String javaType2DatabaseType(String javaDataType);
}
 