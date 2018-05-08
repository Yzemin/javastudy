package com.ziv.clazz.agent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   下午1:17:04 
 * 类说明 :
 * 
*/
class Book{
	public void print() {
		System.out.println("I am a book!");
	}
}
interface IDao{
	public boolean insert();
	public int save(String sql);
}
class BookService implements IDao{

	@Override
	public boolean insert() {
		System.out.println("JDBC - insert");
		return true;
	}

	@Override
	public int save(String sql) {
		System.out.println("JDBC - save");
		return 1;
	}
	
}
class FactoryProxy implements InvocationHandler{
	private Object targert;
	public Object bind(Object obj) {
		this.targert = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName());
		System.out.println(args[0]);
		return method.invoke(this.targert, args);
	}
	
}
public class MyProxy {
	public static void main(String[] args) {
		IDao bookService= (IDao) new FactoryProxy().bind(new BookService());
		bookService.save("select * form user");
	}
}
 