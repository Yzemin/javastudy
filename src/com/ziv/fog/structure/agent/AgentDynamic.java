package com.ziv.fog.structure.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ziv
 * 代理模式 aop
 *		-抽象角色，真实角色，代理角色
 *		-动态代理，静态代理
 * java.lang.reflect.proxy(动态生成代理类的对象),
 * java.lang.reflect.InvocationHandler (处理器接口)
 */
interface Star{
	void confer();
	void sing();
}
//	真实对象
class RealStar implements Star{

	@Override
	public void confer() {
		System.out.println("RealStar: confer");
	}

	@Override
	public void sing() {
		System.out.println("RealStar: sing");
	}
	
}
//	动态代理类
class StarHandler implements InvocationHandler{

	private Star realStar;
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//	业务处理
		System.out.println("代理类即将执行："+method.getName().toString());
		if(!method.getName().equalsIgnoreCase("sing")){
			return null;
		}
		return method.invoke(realStar, args);
	}
	
}

public class AgentDynamic{
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler starHandler = new StarHandler(realStar);
		Star proxy = (Star) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[]{Star.class}, starHandler);
		proxy.confer();
		proxy.sing();
	}
}
