package com.ziv.clazz.function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author ziv 八重齒
 * 	反射 get set
 *
 */
class Dept{
	private String dname;
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
}

public class FunctionGetSet {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		String className = "com.ziv.clazz.function.Dept";
		String property = "dname";
		
		Class<?> cls = Class.forName(className);
		
		Method setMet = cls.getDeclaredMethod("set"+initcap(property), String.class);	//	获取方法
		Method getMet = cls.getDeclaredMethod("get"+initcap(property));
		
		Object obj = cls.newInstance();
		setMet.invoke(obj, "Yang zemin");
		System.out.println(getMet.invoke(obj));
	}
	/**
	 * 首字母变为大写
	 * @param str
	 * @return
	 */
	private static String initcap(String str){
		if(str == null ){
			return null;
		}
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
}
