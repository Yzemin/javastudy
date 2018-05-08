package com.ziv.clazz.agent.service;

import com.ziv.clazz.agent.dao.IDeptService;

import lombok.extern.java.Log;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午9:26:59 
 * 类说明 :
 * 
*/
@Log
public class DeptServiceImpl implements IDeptService {
	@Override
	public boolean insert() throws Exception {
		System.out.println("JDBC 业务");
		return true;
	}

}
 