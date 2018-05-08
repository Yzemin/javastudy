package com.ziv.clazz.clazz;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * 	Class<?> cls = Clazz.class;
	MyFactoryClass an = cls.getAnnotation(MyFactoryClass.class);
	String className = an.className();
	Class<?> ins = Class.forName(className);
	Message obj = (Message) ins.newInstance();
	obj.print("rain");
*/

@Retention(value = RetentionPolicy.RUNTIME)
@interface MyFactoryClass{
	public String className();
}

interface Message{
	public void print(String str);
}

class News implements Message{
	public void print(String str) {
		System.out.println("NEWS: " + str);
	}
}

class Email implements Message{
	public void print(String str) {
		System.out.println("Email: " + str);
	}
}

@MyFactoryClass(className = "com.ziv.clazz.clazz.News")
public class Clazz {
	public static void main(String[] args) throws Exception {
		getMessageNew().print("rain");
	}
	
	public static Message getMessageNew() throws Exception{
		Class<?> cls = Clazz.class;
		MyFactoryClass an = cls.getAnnotation(MyFactoryClass.class);
		String className = an.className();
		Class<?> ins = Class.forName(className);
		return (Message) ins.newInstance();
	}
}
