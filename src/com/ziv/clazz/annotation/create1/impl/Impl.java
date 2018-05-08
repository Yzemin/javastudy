package com.ziv.clazz.annotation.create1.impl;

import java.io.Serializable;
import java.sql.SQLException;

import com.ziv.clazz.annotation.create1.annotation.Annotion;
import com.ziv.clazz.annotation.create1.dao.IDao;
import com.ziv.clazz.annotation.create1.query.Query;

/**
 * @author 作者 E-mail: ziv 八重齿 @2374619909.com
 * @version 创建时间： 2018年4月21日 上午10:34:25 类说明 :
 * 
 */
public class Impl implements IDao, Serializable {
	@Annotion(value = "start")
	public void update() throws Exception {
		Query query = new Query();
		query.update("update users set password='1' where powers=0");
		int i = 1 / 0;
		query.update("update users set password='123' where powers=3");
	}

}
