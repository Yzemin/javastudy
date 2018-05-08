package com.ziv.clazz.annotation.create2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 
 * @author ziv
 *	注解对象 实现 jdbc 事务
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annotion{
	public String value() default "stop";
}
