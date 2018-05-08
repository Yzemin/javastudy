package self.ziv.som.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午10:02:57 
 * 类说明 :
 * 		存儲表結構信息
*/
public class TableInfo {
	/*	表名	*/
	private String tname;
	/*	所有字段信息	*/
	private Map<String,ColumnInfo> columns;
	/*	主鍵	*/
	private ColumnInfo onlyPrikey;
	/*	聯合主鍵	*/
	private List<ColumnInfo> prikeys;
	
	
	public List<ColumnInfo> getPrikeys() {
		return prikeys;
	}
	public void setPrikeys(List<ColumnInfo> prikeys) {
		this.prikeys = prikeys;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPrikey() {
		return onlyPrikey;
	}
	public void setOnlyPrikey(ColumnInfo onlyPrikey) {
		this.onlyPrikey = onlyPrikey;
	}
	public TableInfo() {
		super();
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPrikey, List<ColumnInfo> prikeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPrikey = onlyPrikey;
		this.prikeys = prikeys;
	}
	public TableInfo(String tname,List< ColumnInfo> prikeys, HashMap<String, ColumnInfo> columns) {
		this.tname = tname;
		this.columns = columns;
		this.prikeys = prikeys;
	}
}
 