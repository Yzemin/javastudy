package com.ziv.util.string; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月6日   下午6:47:30 
 * 类说明 :
 * 
*/
public class StringUtiles {
	public static String initcap(String str){
		if(str == null ) return null;
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
}
 