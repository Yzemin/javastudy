package com.ziv.java8.homework;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ziv.bean.Employee;
import com.ziv.bean.Employee.Status;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月29日   下午12:44:26 
 * 类说明 :
 * 
*/
public class TestStreamAPI {
	@Test
	public void dome1() {
		
		
		
//		System.out.println(employees.stream().count());
//		System.out.println(employees.size());
//		System.out.println(
//				employees.stream()
//				.map(e->1).reduce(Integer::sum));
		
//		List<Integer> ints = Arrays.asList(1,2,3,4,5);
//		ints.stream().map(e->e*e).forEach(System.out::println);
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee("张山",18,9999.99,Status.FREE),
			new Employee("李四",58,5555.55,Status.BUSY),
			new Employee("王五",26,3333.33,Status.VOCATION),
			new Employee("赵六",36,6666.66,Status.FREE),
			new Employee("田七",12,8888.88,Status.BUSY),
			new Employee("田七",12,8888.88,Status.VOCATION)
		);
	
}
 