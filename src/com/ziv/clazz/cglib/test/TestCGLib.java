package com.ziv.clazz.cglib.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   下午12:48:35 
 * 类说明 :	cglib 代理，不受接口的限制
 * 
*/
class Book{
	public void get() {
		System.out.println("get a book");
	}
}
class BookProxy implements MethodInterceptor{
	private Object target;
	public BookProxy(Object target) {
		this.target = target;
	}
	public void pay() {
		System.out.println("pay $19.8");
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		this.pay();
		return method.invoke(this.target, args);
	}
	
}
public class TestCGLib {
	public static void main(String[] args) {
		Book book = new Book();	//	必须有一个真实对象
		Enhancer enhancer = new Enhancer();	//	代理对象工具类
		enhancer.setSuperclass(Book.class);	//	父级对象
		enhancer.setCallback(new BookProxy(book));
		Book proxy = (Book)enhancer.create();	//	创建代理对象
		proxy.get();
	}
}
 