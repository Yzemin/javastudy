package com.ziv.homework.javaoop17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.junit.Test;

import com.ziv.homework.javaoop17.op.Animal;
import com.ziv.homework.javaoop17.op.Duck;

/**
 * @author 作者 E-mail: ziv 八重齿 @2374619909.com
 * @version 创建时间： 2018年5月6日 下午7:53:43 类说明 :
 * 
 */
public class Homework {
	// 1、创建一个集合，里面有int型，String型，Duck型的三个元素:
	// a.通过今天所讲的迭代器的方式，和增强for循环的方式，遍历里面的集合。
	// b.再创建两个集合，让两个集合比较时，返回为true
	@Test
	public void dome1() {
		List<Object> list = new ArrayList<Object>();
		list.add(10001);
		list.add("张增红");
		list.add(new Duck("老虎", "猫科"));

		list.stream().forEach(System.out::println);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		for (Object obj : list) {
			System.out.println(obj);
		}

		List<Object> list2 = Arrays.asList("张", 15200, new Duck("老虎", "猫科"));
		List<Object> list3 = Arrays.asList("张", 15200, new Duck("老虎", "科"));
		System.out.println(eq(list2,list3));

	}

	public boolean eq(List e1, List e2) {
		if (e1.size() != e2.size())
			return false;
		for (int i = 0; i < e1.size(); i++) {
			if (!e1.get(i).equals(e2.get(i))) {
				return false;
			}
		}
		return true;

	}

	//
	//
	// 2、定义一个List集合，只能往里面添加Animal类型的数据
	@Test
	public void dome2() {
		List<Animal> lists = new ArrayList<>();
		lists.add(new Animal("老虎", "猫科"));
		
		MyList list = new MyList();
		list.add(new Animal("老虎", "猫科"));
		System.out.println(list.indexOf(0));
	}

	// 3、定义一个Map集合，类型为Animal，插入4个animal的对象作为key值，value值自定义，
	// 插入的4个对象中，必须要其中两个对象的所有属性相同，然后遍历里面的元素，看输出是几个元素。
	@Test
	public void dome3() {
		Map<String, Animal> map = new HashMap<>();
		Animal dog = new Animal("狗", "犬科");
		Animal cat = new Animal("猫", "犬科");
		Animal pig = new Animal("猪", "不晓得");
		Animal durk = new Animal("鸭子", "牙科");
		map.put("dog", dog);
		map.put("cat", cat);
		map.put("durk", pig);
		map.put("durk", durk);
		map.keySet().stream().forEach(key -> System.out.println(map.get(key)));
		System.out.println("-------ENTRY STREAM----------");
		map.entrySet().stream().forEach(System.out::println);
		map.entrySet().stream().forEach(key -> System.out.println(key.getValue()));
		System.out.println("-----------------");
		for (Entry key : map.entrySet()) {
			System.out.println(key.getValue());
		}
		System.out.println("-----------------");
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}

	@Test
	public void domeMyList() {

	}

	public static void main(String[] args) {
		MyList list = new MyList();
		list.add("ziv");
		list.add(1001);
		list.add(1001);
		System.out.println(list.indexOf(2));
		for (Object o : list) {
			System.out.println(o);
		}
	}

}

class MyList<E> implements Collection<E> {
	private final int len = 2;
	private int index = 0;
	Object[] obj = null;

	public MyList() {
		obj = new Object[len];
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public boolean isEmpty() {
		return index > 0 ? false : true;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(obj, index);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		if (index == 0) {
			obj[index++] = e;
		} else if (index % len != 0) {
			obj[index++] = e;
		} else {
			obj = Arrays.copyOf(obj, index + len);
			obj[index++] = e;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	public Object indexOf(int index) {
		return obj[index];
	}

}
