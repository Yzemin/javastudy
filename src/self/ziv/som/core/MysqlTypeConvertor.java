package self.ziv.som.core; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   下午1:17:36 
 * 类说明 :
 * 		mysql 數據庫轉汎起
*/
public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String databaseType2JavaType(String columnType) {
		if("varchar".equalsIgnoreCase(columnType)
				|| "char".equalsIgnoreCase(columnType)
				|| "nvarchar".equalsIgnoreCase(columnType))
			return "String";
		else if("int".equalsIgnoreCase(columnType)
				|| "tinyint".equalsIgnoreCase(columnType)
				|| "smallint".equalsIgnoreCase(columnType)
				|| "integer".equalsIgnoreCase(columnType))
			return "Integer";
		else if("bigint".equalsIgnoreCase(columnType))
			return "Long";
		else if("double".equalsIgnoreCase(columnType))
			return "Double";
		else if("float".equalsIgnoreCase(columnType))
			return "Float";
		else if("clob".equalsIgnoreCase(columnType))
			return "Blob";
		else if("date".equalsIgnoreCase(columnType))
			return "Date";
		else if("time".equalsIgnoreCase(columnType))
			return "Time";
		else if("timestamp".equalsIgnoreCase(columnType))
			return "Timestamp";
		else if("enum".equalsIgnoreCase(columnType))
			return "char";
		else
			return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		return null;
	}

}
 