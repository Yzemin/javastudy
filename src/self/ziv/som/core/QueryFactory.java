package self.ziv.som.core; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:41:06 
 * 类说明 :
 * 
*/
public class QueryFactory {
	private static QueryFactory factory =new QueryFactory();
	private static Query mysqlQuery = null;
	static {
		mysqlQuery = new MysqlQuery();
	}
	private QueryFactory() {
	}
	public static Query createQuery() {
		return mysqlQuery;
	}
	public static void main(String[] args) {
		Query createQuery = QueryFactory.createQuery();
	}
}
 