package com.ziv.clazz.annotation.create1.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.ziv.clazz.annotation.create1.annotation.Annotion;
import com.ziv.clazz.annotation.create1.dao.IDao;
import com.ziv.clazz.annotation.create1.utils.TransationManager;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月21日   上午10:36:39 
 * 类说明 :
 * 
*/
public class Agent implements InvocationHandler{

	private IDao dao = null;
	public Agent(IDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Method met = dao.getClass().getMethod(
				method.getName());
		Annotion an = met.getAnnotation(Annotion.class);
		System.out.println(an.value());
		if("start".equalsIgnoreCase(an.value())) {
//		1	TransationManager.commit();
			method.invoke(dao, args);
			TransationManager.rollback();			
		}
		
		return null;
	}

}
 