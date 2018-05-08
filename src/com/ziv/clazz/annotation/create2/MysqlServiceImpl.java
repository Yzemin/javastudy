package com.ziv.clazz.annotation.create2;

import java.io.Serializable;

@Annotion(value="start1")
public class MysqlServiceImpl implements IServiceImpl,Serializable {
	@Annotion(value="start")
	public void update(){
//		IQuery query = new MysqlQuery();
//		query.update("UPDATE user SET  pwd='234' WHERE id=1");
//		int r = 1/0;
//		query.update("UPDATE user SET  pwd='000' WHERE id=1");
		System.out.println("SSS");
	}
}
