package com.ziv.clazz.agent.test; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午11:30:38 
 * 类说明 :
 * 
*/

import com.ziv.clazz.agent.dao.IDeptService;
import com.ziv.clazz.factory.ServiceFactory;

public class TestService {
	public static void main(String[] args) throws Exception {
		IDeptService service = ServiceFactory.getIDeptServiceInstance();
		service.insert();
	}
}
 