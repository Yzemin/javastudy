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
/*	淺克隆-> 同一對象克隆	*/
@Data
@AllArgsConstructor 
class SheepLow implements Cloneable {
	private String sname;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
	
}

public class Proto {
	public static void main(String[] args) throws Exception {
		SheepLow sheepLow1 = new SheepLow("admin",new Date());
		System.out.println(sheepLow1.getSname());
		System.out.println(sheepLow1.getBirthday());
		
		SheepLow sheepLow2 = (SheepLow) sheepLow1.clone();
		System.out.println(sheepLow2.getSname());
		System.out.println(sheepLow2.getBirthday());
		
		System.out.println(sheepLow1 == sheepLow2);
		
	}
}












