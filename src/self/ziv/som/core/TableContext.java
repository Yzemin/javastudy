package self.ziv.som.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import self.ziv.som.bean.ColumnInfo;
import self.ziv.som.bean.TableInfo;
import self.ziv.som.utils.JavaFileUtils;
import self.ziv.som.utils.StringUtils;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:47:26 
 * 类说明 :
 * 		負責管理數據庫
*/
public class TableContext {
	/*	表名為key,表信息為value	*/
	private static Map<String,TableInfo> tables = new HashMap<String,TableInfo>();
	/*	將po的class對象和表信息對象關聯	*/
	private static Map<Class,TableInfo> poClassTableMap = new HashMap<Class, TableInfo>();
	
	private TableContext() {}
	
	static {
		try {
			Connection con = DBManager.getConn();
			DatabaseMetaData dbmd = con.getMetaData();
			//	查詢數據庫中所有表
			ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] {"TABLE"});
			while(tableRet.next()) {
				String tableName = (String) tableRet.getObject("TABLE_NAME");
				TableInfo ti = new TableInfo(
						tableName,
						new ArrayList<ColumnInfo>(),
						new HashMap<String,ColumnInfo>());
				tables.put(tableName, ti);
				//	查詢表中所有字段
				ResultSet setColumns = dbmd.getColumns(null, "%", tableName, "%");
				while(setColumns.next()) {
					ColumnInfo ciColumn = new ColumnInfo(setColumns.getString("COLUMN_NAME"),
							setColumns.getString("TYPE_NAME"),0);
					ti.getColumns().put(setColumns.getString("COLUMN_NAME"), ciColumn);
				}
				//	獲取表中所有字段
				ResultSet setkey = dbmd.getPrimaryKeys(null, "%", tableName);
				while(setkey.next()) {
					ColumnInfo cikey = (ColumnInfo)ti.getColumns().get(setkey.getObject("COLUMN_NAME"));
					cikey.setKeyType(1);
					ti.getPrikeys().add(cikey);
				}
				if(ti.getPrikeys().size()>0) {
					ti.setOnlyPrikey(ti.getPrikeys().get(0));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		updateJavaPOFile();
		loadPOTables();
	}
	
	public static Map<String,TableInfo> getTableInfos(){
		return tables;
	}
	/**
	 * 創建po包
	 */
	public static void updateJavaPOFile() {
		Map<String, TableInfo> tables = TableContext.getTableInfos();
		for (TableInfo t : tables.values()) {			
			JavaFileUtils.createJavaPOFile(t, new MysqlTypeConvertor());
		}
	}
	/**
	 * 加載po 包下的類
	 */
	public static void loadPOTables() {
		for(TableInfo tabeTnfo:tables.values()) {
			try {				
				Class c = Class.forName(
						DBManager.getConf().getPoPackage() + "." +
						StringUtils.firstChar2UpperCase(tabeTnfo.getTname()));
				poClassTableMap.put(c, tabeTnfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<Class, TableInfo> getPoClassTableMap() {
		return poClassTableMap;
	}
	public static void main(String[] args) {
		TableContext.updateJavaPOFile();
	}
}
 