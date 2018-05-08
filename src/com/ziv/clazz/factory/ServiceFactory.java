package com.ziv.clazz.factory; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午11:22:45 
 * 类说明 :
 * 
*/

import com.ziv.clazz.agent.dao.IDeptService;
import com.ziv.clazz.agent.service.DeptServiceImpl;
import com.ziv.clazz.agent.service.DeptServiceProxy;
import com.ziv.clazz.agent.service.ServiceProxy;

public class ServiceFactory {
	public static IDeptService getIDeptServiceInstanceStatic() {
		return new DeptServiceProxy(new DeptServiceImpl());
	}
	
	public static IDeptService getIDeptServiceInstance() {
		return (IDeptService)new ServiceProxy().bind(new DeptServiceImpl());
	}
}
 