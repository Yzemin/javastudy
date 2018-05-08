package com.ziv.fog.creator.breaksingle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * @author ziv
 * 创建者单例模式 -》单例懒汉式
 * 防止反射与反序列化
 *  延迟加载
 *		每次调用 getInstance 都是单线程，速度慢
 */
public class SingleSlacker implements Serializable{
	private static SingleSlacker singleSlacker= null;
	private SingleSlacker() {
		//	防止反射与反序列化,在反射中任然可以创建对象
		if(singleSlacker!=null){
			throw new RuntimeException();
		}
	}
	//	synchronized -> 避免多线程时的并发
	public static synchronized SingleSlacker getInstance(){
		if(null == singleSlacker){
			singleSlacker = new SingleSlacker();
		}
		return singleSlacker;
	}
	//	反序列化
	private Object readResolve() throws ObjectStreamException{
		return singleSlacker;
	}
	
	public static void main(String[] args) throws Exception {
		SingleSlacker single1 = SingleSlacker.getInstance();
		SingleSlacker single2 = SingleSlacker.getInstance();
		System.out.println(single1 == single2);
		System.out.println(single1);
		//	反射创建对象
		/*Class<?> clazz = Class.forName("com.ziv.fog.creator.breaksingle.SingleSlacker");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);	//	开启访问私有属性
		SingleSlacker singleClazz1 = (SingleSlacker) constructor.newInstance();
		SingleSlacker singleClazz2 = (SingleSlacker) constructor.newInstance();
		System.out.println(singleClazz1);
		System.out.println(singleClazz2);
		System.out.println(singleClazz1 == singleClazz2);*/
		
		//	------------反序列化创建对象-------------------
		FileOutputStream fos = new FileOutputStream("D:a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(single1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:a.txt"));
		SingleSlacker ss = (SingleSlacker)ois.readObject();
		System.out.println(ss);
	}
	
	
}
