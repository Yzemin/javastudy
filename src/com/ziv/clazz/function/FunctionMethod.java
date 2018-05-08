package com.ziv.clazz.function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author ziv 八重齒
 *
 */
class Mess{
	public void print(String str){
		System.out.println(str);
	}
}
class MessZiv{
	public String print(String str){
		return "ziv "+str;
	}
}
public class FunctionMethod {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MessZivFuntion();
	}
	
	public static void MessFuntion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class<?> cls = Class.forName("com.ziv.clazz.function.Mess");
		Object obj = cls.newInstance();
		Method met = cls.getMethod("print", String.class);
		met.invoke(obj, "Hello world !");
	}
	
	public static void MessZivFuntion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		Class<?> cls = Class.forName("com.ziv.clazz.function.MessZiv");
		Object obj = cls.newInstance();
		Method met = cls.getMethod("print", String.class);
		System.out.println(met.invoke(obj, "Hello world !"));
	}
}
