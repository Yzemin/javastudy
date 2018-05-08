package com.ziv.clazz.field;

import java.lang.reflect.Field;

public class FieldParams {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.ziv.bean.User");
		Field[] f = (Field[]) cls.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i].getName());
			System.out.println(f[i].getType().toString().substring(
					f[i].getType().toString().lastIndexOf(".")+1, f[i].getType().toString().length()));
			System.out.println(f[i].getModifiers());
		}
	}
}
