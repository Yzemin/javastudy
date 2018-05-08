package self.ziv.som.bean; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:52:07 
 * 类说明 :
 * 		數據庫表中字段
*/
public class ColumnInfo {
	/*	字段名稱	*/
	private String name;
	/*	字段數據類型	*/
	private String dataType;
	/*	字段的建類型(0-> 普通,1-> 主鍵，2->外鍵)	*/
	private int keyType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getKeyType() {
		return keyType;
	}
	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}
	public ColumnInfo(String name, String dataType, int keyType) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.keyType = keyType;
	}
	public ColumnInfo() {
		super();
	}
	
}
 