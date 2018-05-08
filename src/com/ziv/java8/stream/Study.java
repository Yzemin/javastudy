package com.ziv.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.ziv.bean.Employee;
import com.ziv.bean.Employee.Status;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月23日   下午6:03:11 
 * 类说明 :
 * 
 * **	筛选与切片	**
 * 	filter	-	排除xx元素
 * 	limit	-	定数量
 * 	skip		-	跳过前几个
 * 	distinct	-	去除重复元素,根据hashcode,eqeust
 * 
 * **	Stream_映射	**
 * 	map		-	将集合里面每一项都进行操作
 * 	flatMap	-	将集合里面每一个元素都变为流
 * 
 * **	排序	**
 * 	sorted	-	自然排序(Comparable)
 * 	sorted(Comparator)	-	定制排序(Comparator)
 * 
 * **	终止操作	**
 * 	allMatch	-	匹配所有元素
 * 	anyMathch	-	检查是否至少匹配一个元素
 * 	noneMatch	-	检查是否没有匹配所有元素
 * 	findFirst	-	
 * 	findAny		-
 * 	coundt		-	
 * 	max			-
 * 	min			-	
 * ---------------
 * 	reduce(identity,BinaryOperator)/reduce(BinaryOperator)	-	将流中元素结合起来得到一个新值
 * 	collect		-	收集器(接口)/Collectors
 * 		--
 * 
 * **		并行流与串行流	**
 * 				-fork/join框架
 * 	
*/
public class Study {
	List<Employee> employees = Arrays.asList(
			new Employee("张山",18,9999.99,Status.FREE),
			new Employee("李四",58,5555.55,Status.BUSY),
			new Employee("王五",26,3333.33,Status.VOCATION),
			new Employee("赵六",36,6666.66,Status.FREE),
			new Employee("田七",12,8888.88,Status.BUSY),
			new Employee("田七",12,8888.88,Status.VOCATION)
		);
	List<String> strs = Arrays.asList("cc","bb","aa","jj","ff");
	List<String[]> strss = Arrays.asList(
			new String[] {"aa","bb"},
			new String[] {"cc","s"},
			new String[] {"x","z"});
	List<Integer> ints = Arrays.asList(22,23,1,23,56,23,11,2,89);
	
	@Test
	public void dome5() {
//		System.out.println(
//				ints.stream().reduce(0,(x,y)->x+y));
//		System.out.println(
//			employees.stream()
//				.map(Employee::getSto)
//				.reduce(Double::sum));
		
//		employees.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
		
//		System.out.println(
//			employees.stream().map(Employee::getAge).collect(Collectors.counting()).toString());
		
//		System.out.println(
//				employees.stream().collect(Collectors.averagingDouble(Employee::getAge)).toString());
		
//		System.out.println(
//				employees.stream().collect(Collectors.summarizingDouble(Employee::getSto)).toString());
		
//		System.out.println(
//				employees.stream().collect(Collectors.maxBy(
//							(e1,e2) -> Double.compare(e1.getSto(), e2.getSto())
//						)).get());
		
//		System.out.println(
//				employees.stream().collect(Collectors.minBy(
//							(e1,e2) -> Double.compare(e1.getSto(), e2.getSto())
//						)).get());
		
//		System.out.println(
//				employees.stream().collect(Collectors.groupingBy(Employee::getStatus)).toString());
		
//		Map<Status, Map<String, List<Employee>>> collect = employees.stream().collect(
//				Collectors.groupingBy(
//						Employee::getStatus,Collectors.groupingBy(
//								e->{
//									if(e.getAge()<35)
//										return "35";
//									return "00";
//								})));
//		System.out.println(collect);
		
		/*	分区	*/
//		System.out.println(
//				employees.stream().collect(Collectors.partitioningBy(e->e.getAge()>35)).toString());
	}
	
	@Test
	public void dome4() {
		/*System.out.println(employees.stream().allMatch(
				e->e.getStatus().equals(Status.BUSY)));*/
		
		/*System.out.println(employees.stream().anyMatch(
				e->e.getStatus().equals(Status.BUSY)));*/
		
		/*System.out.println(employees.stream().noneMatch(
				e->e.getStatus().equals(Status.BUSY)));*/
		/*
		Stream<Employee> sorted = employees.stream().sorted(
				(e1,e2)->Double.compare(e1.getSto(), e2.getSto())
			);
		sorted.forEach(System.out::println);
		System.out.println("-----------------");
		System.out.println(sorted.findFirst().get());
		System.out.println(sorted.findAny().get());*/
		
//		Double db = employees.stream()
//			.map(Employee::getSto)
//			.min(Double::compare).get();
//		System.out.println(db);
		
		
	}
	
	@Test
	public void dome3() {
//		strs.stream().sorted().forEach(System.out::println);
		employees.stream().sorted(
				(e1,e2)->{
					if(e1.getAge().equals(e2.getAge())) {
						return e1.getName().compareTo(e2.getName());
					}else {
						return e1.getAge().compareTo(e2.getAge());
					}
				}
				).forEach(System.out::println);
	}
	@Test
	public void dome1() {
		/*Stream<Employee> s = employees.stream()
				.filter((e) -> e.getAge() > 35);
		s.forEach(System.out::println);*/
		
//		employees.stream().filter(e -> e.getAge()>35).forEach(System.out::println);
		
		/*employees.stream().filter(e -> {
				System.out.println("** filter Stream API **");	
				return e.getAge()>35;
			}).forEach(System.out::println);*/
		
		/*employees.stream().filter(e -> {
			System.out.println("** limit Stream API **");
			return e.getSto()>5000;
		}).limit(2).forEach(System.out::println);*/
		
		/*employees.stream().filter(e ->{
				System.out.println("** skip Stream API **");
				return e.getSto()>5000;
			}).skip(2).forEach(System.out::println);*/
		
		/*employees.stream().filter(e ->{
			System.out.println("** distinct Stream API **");
			return e.getSto()>5000;
		}).distinct().forEach(System.out::println);*/
		
	}
	
	@Test
	public void dome2() {
//		strs.stream().map(e->e.toUpperCase()).forEach(System.out::println);
		
//		employees.stream().map(e->e.getName()).forEach(System.out::println);
		
//		strss.stream().flatMap(e -> e.toString());
	}
}
 