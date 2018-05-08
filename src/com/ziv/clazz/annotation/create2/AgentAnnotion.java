package com.ziv.clazz.annotation.create2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AgentAnnotion implements InvocationHandler{
	private IServiceImpl IserviceImpl;
	public AgentAnnotion() {
	}
	public AgentAnnotion(IServiceImpl IserviceImpl) {
		super();
		this.IserviceImpl = IserviceImpl;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Annotation[] an = IserviceImpl.getClass().getAnnotations();
		for (int i = 0; i < an.length; i++) {
			System.out.println(an[i]);
		}
		
		return method.invoke(IserviceImpl, args);
	}

}
