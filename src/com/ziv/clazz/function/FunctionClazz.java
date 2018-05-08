package com.ziv.clazz.function;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 
 * @author ziv 八重齿
 * DSEC: 反射 自定义方法 拼接
 *
 */
interface Message{
	public void print();
}
abstract class Info{
	public abstract void get();
}
class MessageImpl extends Info implements Message{

	public void print() {
		
	}
	public void get() {
	}
	public void set(){
		
	}
}
public class FunctionClazz {

	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("com.ziv.clazz.function.MessageImpl");
		Method met[] = cls.getMethods();	//	获取所有本类的方法
//		met = cls.getDeclaredMethods();	//	获取对象的方法，本类中的方法，与继承无关
		for (int i = 0; i < met.length; i++) {
//			System.out.println(met[i]);
			System.out.print(Modifier.toString(met[i].getModifiers()) + " ");
			System.out.print(met[i].getReturnType().getSimpleName() + " ");
			System.out.print(met[i].getName() + "(");
			Class<?> params[] = met[i].getParameterTypes();
			for (int j = 0; j < params.length; j++) {
				System.out.print(params[j].getSimpleName() + " arg"+j);
				if(j < params.length -1){
					System.out.print(", ");
				}
			}
			System.out.print(") ");
			Class<?> exp[] = met[i].getExceptionTypes();
			if(exp.length >0){
				System.out.print("throw ");
			}
			for (int j = 0; j < exp.length; j++) {
				System.out.print(exp[j].getSimpleName());
				if(j < params.length -1){
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

}
