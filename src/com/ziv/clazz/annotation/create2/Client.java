package com.ziv.clazz.annotation.create2;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		IServiceImpl impl = new MysqlServiceImpl();
		AgentAnnotion agent = new AgentAnnotion(impl);
		IServiceImpl  proxy= (IServiceImpl)Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[]{IServiceImpl.class}, agent);
		proxy.update();
	}
}
