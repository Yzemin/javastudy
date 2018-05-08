package com.ziv.clazz.annotation.create1.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月21日   上午10:31:43 
 * 类说明 :
 * 
*/
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Annotion {
	public String value() default "start";
}
 