package com.ziv.clazz.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
/**
 * 
 * @author ziv 八重齿 
 * DSEC: 类对象的构造方法的反射！拼接
 *
 */
class Book{
	private String title;
	private Double price;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public Book(String title,Double price) throws NoClassDefFoundError,IllegalAccessError{
		this.title = title;
		this.price = price;
	}
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
}
public class StructureClazz {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.ziv.clazz.constructor.Book");
		//		必须有无惨构造
		//		System.out.println(cls.newInstance());
		//		取得所有构造方法
		/*
		 * --------------------Class.forName("xx.xx.xx.Xx").getConstructors()-----------------------
		 * public	->	1;
		 * static 	->	5;
		 * final	->	7;
		 * abstract	->	9;
		 */
		Constructor<?> cons[] = cls.getConstructors();	//	获取所有构造方法
		for (int i = 0; i < cons.length; i++) {
//			System.out.println(cons[i]);
//			System.out.println(cons[i].getModifiers());	//	获取构造方法的修饰符
			System.out.print(Modifier.toString(cons[i].getModifiers())+" ");	// 	还原构造方法
			System.out.print(cons[i].getName() + "(");	//	获取构造方法的名称
			
			Class<?>[] params = cons[i].getParameterTypes();	//	获取所有构造方法的类型
			for (int j = 0; j < params.length; j++) {
//				System.out.print(params[j].getName());	//	获取构造方法的参数类型
				System.out.print(params[j].getSimpleName() + 
						" arg" + j);	//	获取简单构造方法中的参数类型
				if(j < params.length - 1){
					System.out.print(",");
				}
			} 
			System.out.print(")");
			Class<?> exp[] = cons[i].getExceptionTypes();	//	获取构造方法的全部异常
			if(exp.length > 0){
				System.out.print(" throws ");
				for (int j = 0; j < exp.length; j++) {
					System.out.print(exp[j].getSimpleName());	//	获取简单异常中的参数类型
					if(j < exp.length -1){
						System.out.print(",");
					}
				}
			}
			System.out.println();
		}
	}
}
