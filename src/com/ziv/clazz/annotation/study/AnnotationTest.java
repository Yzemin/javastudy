package com.ziv.clazz.annotation.study;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author ziv 八重齿
 * 	
 * 	注解	-	Annotation
 * 		范围:
 * 			CLASS:		类中
 * 			RUNTIME:	程序运行中
 * 			SOURCE:		类文件中
 * 
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyFactory{
	public String name() default "ziv";
	public String value();
}

@MyFactory(value = "ziv")
@SuppressWarnings("serial")
@Deprecated
class Student implements Serializable{}

public class AnnotationTest {
	public static void main(String[] args) {
		Class<?> cls = Student.class;
		//	get all annotation
		Annotation[] an = cls.getAnnotations();
		for (int i = 0; i < an.length; i++) {
			System.out.println(an[i]);
		}
		//	get one annotation of MyFactory.class
		MyFactory annotation = cls.getAnnotation(MyFactory.class);
		System.out.println(annotation);
		System.out.print("ANNOTATION:name,value  " + annotation.name() +","+ annotation.value());
	}
}
