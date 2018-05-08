package self.ziv.som.bean; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   下午1:28:19 
 * 类说明 :
 * 		生成java 屬性 get set
*/
public class JavaFieldGetSet {
	/*	屬性的源碼信息	*/
	private String fieldInfo;
	/*	屬性源碼的get信息	*/
	private String getInfo;
	/*	屬性源碼的set信息	*/
	private String setInfo;
	
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet() {
		super();
	}
	
	public void toStringSelf() {
		System.out.println(this.fieldInfo);
		System.out.println(this.getInfo);
		System.out.println(this.setInfo);
	}
	
}
 