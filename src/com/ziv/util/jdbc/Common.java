package com.ziv.util.jdbc;

public class Common {
	/**
	 * 判断参数是否是空
	 * @param objs 基本数据类型
	 * @return
	 */
	public static boolean parmsIsNull(Object... objs){
		for (Object obj : objs) {
			if(obj == null){
				return true;
			}
		}
		return false;
	}
}
