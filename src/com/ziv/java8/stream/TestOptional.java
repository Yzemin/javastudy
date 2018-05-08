package com.ziv.java8.stream;

import java.util.Optional;

import org.junit.Test;

import com.ziv.bean.Employee;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月29日   下午1:48:22 
 * 类说明 :
 * 		容器类，空指针
*/


public class TestOptional {
	@Test
	public void dome3() {
		Optional<Employee> op = Optional.ofNullable(new Employee());
		if(op.isPresent())
			System.out.println(op.get().getName());
		
		Employee orElse = op.orElse(new Employee("ziv",18,9.9));
		System.out.println(orElse);
		
		Employee orElseGet = op.orElseGet(()->new Employee("ziv",18,9.9));
		System.out.println(orElseGet);
	}
	@Test
	public void dome2() {
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
	}
	@Test
	public void dome1() {
		Optional<Employee> op = Optional.of(new Employee());
		System.out.println(op.get().getSto());
	}
}
 