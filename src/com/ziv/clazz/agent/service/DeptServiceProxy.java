package com.ziv.clazz.agent.service;

import com.ziv.clazz.agent.dao.IDeptService;
import com.ziv.clazz.agent.dao.IDeptServiceProxy;

import lombok.extern.java.Log;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午9:26:59 
 * 类说明 :
 * 
*/
@Log
public class DeptServiceProxy implements IDeptService {
	
	private IDeptService deptService;
	public DeptServiceProxy(IDeptService deptService) {
		this.deptService = deptService;
	}
	public void prepare() {
		log.info("JDBC-conn");
	}
	public void destroy() {
		log.info("JDBC-close");
	}
	
	@Override
	public boolean insert() throws Exception {
		this.prepare();
		boolean flag = this.deptService.insert();
		this.destroy();
		return flag;
	}

}
 