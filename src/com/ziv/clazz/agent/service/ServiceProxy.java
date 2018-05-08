package com.ziv.clazz.agent.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.extern.java.Log;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午11:45:02 
 * 类说明 :
 * 		动态代理
*/
@Log
public class ServiceProxy implements InvocationHandler {
	/*	保存真实对象	*/
	private Object target = null;
	/**
	 * 换回动态代理类的对象，通过代理对象操作真实
	 * @param obj 真实业务对象
	 * @return 代理对象
	 */
	public void prepare() {
		log.info("JDBC-conn");
	}
	public void destroy() {
		log.info("JDBC-close");
	}
	public Object bind(Object obj) {
		this.target = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.prepare();
		this.destroy();
		return method.invoke(this.target, args);
	}
	
}
 