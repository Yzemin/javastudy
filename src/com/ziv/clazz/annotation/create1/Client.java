package com.ziv.clazz.annotation.create1;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

import com.ziv.clazz.annotation.create1.aop.Agent;
import com.ziv.clazz.annotation.create1.dao.IDao;
import com.ziv.clazz.annotation.create1.impl.Impl;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月21日   上午10:40:32 
 * 类说明 :
 * 
*/
public class Client {
	public static void main(String[] args) {
		IDao dao = new Impl();
		Agent agent = new Agent(dao);
		IDao poxy = (IDao)Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] {IDao.class},agent);
		try {
			poxy.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 