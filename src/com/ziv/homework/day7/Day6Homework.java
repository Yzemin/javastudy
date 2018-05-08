package com.ziv.homework.day7; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   下午5:17:47 
 * 类说明 :
 * 
*/

import org.junit.Test;

public class Day6Homework {
	@Test
	public void dome1() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char)('A'+j));
			}
			System.out.println();
		}
	}
	@Test
	public void dome2() {
		int count = 'A';
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char)count++);
			}
			System.out.println();
		}
	}
	@Test
	public void dome3() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char)('A'+i));
			}
			System.out.println();
		}
	}
}
 