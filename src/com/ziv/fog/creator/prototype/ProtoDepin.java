package com.ziv.fog.creator.prototype;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月19日   下午6:52:09 
 * 类说明 :
 * 		原型模式/克隆
*/
/*	深克隆-> 同一對象克隆	*/
@Data
@AllArgsConstructor
class SheepDepin implements Cloneable {
	private String sname;
	private Date birthday;

	/*	深度克隆,同時克隆屬性	*/
	@Override
	protected Object clone() throws CloneNotSupportedException {
		SheepDepin obj = (SheepDepin) super.clone();
		obj.birthday = (Date) this.birthday.clone();
		return obj;
	}
	
}

public class ProtoDepin {
	public static void main(String[] args) throws Exception {
		
	}
}












