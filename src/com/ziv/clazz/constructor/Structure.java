package com.ziv.clazz.constructor;

import java.lang.reflect.Constructor;

/**
 * 
 * @author ziv 八重齿 
 * DSEC: 类对象的构造方法的反射！ JAVA
 *
 */
class Book1{
	private String title;
	private Double price;
	public Book1() {}
	public Book1(String title) {
		this.title = title;
	}
	public Book1(String title,Double price) throws NoClassDefFoundError,IllegalAccessError{
		this.title = title;
		this.price = price;
	}
	public String toString() {
		return "Book1 [title=" + title + ", price=" + price + "]";
	}
}
public class Structure {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.ziv.clazz.constructor.Book1");
		Constructor<?> cons = cls.getConstructor(String.class,Double.class);	//	获取构造方法
		Book1 book = (Book1) cons.newInstance("JAVA",86.98);
		System.out.println(book);
	}
}
