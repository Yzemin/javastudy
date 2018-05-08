package com.ziv.homework.day6;
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   上午8:29:15 
 * 类说明 :
 * 
*/

import java.util.Scanner;

import org.junit.Test;

public class Ziv {
	@Test
	public void dome1() {
		System.out.println(leiX(1L));
	}

	@Test
	public void dome2() {
		System.out.println(leiAdd(1));
	}

	private Long leiX(Long i) {
		if (i >= 20)
			return 20L;
		return leiX(i + 1L) * i;
	}

	private int leiAdd(int i) {
		if (i >= 50) return 50;
		return leiAdd(i + 1) + i;
	}

	@Test
	public void dome3() {
		for (int i = 1; i <= 6; i++) {
			for (int j = 6 - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 11 - i * 2; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Test
	public void dome4() {
		Scanner scanner = new Scanner(System.in);
		int num = (int) (Math.random() * 100 + 1);
		int guess = 0;
		System.out.println("-1 : exit");
		do {
			System.out.println("input: ");
			guess = scanner.nextInt();
			if (guess == num) {
				System.out.println("OK!");
				break;
			} else if (guess > num) {
				System.out.println("数字大了点");
			} else if (guess < num) {
				System.out.println("数小了点");
			}
		} while (guess != -1);
	}
	
	@Test
	public void dmoe5() {
		int i = 1,count = 0,numA = 0,numB = 0,value = 0;
		Scanner scanner = new Scanner(System.in);
		while(i <= 10) {
			System.out.println(i +"题:");
			numA = (int)(Math.random() * 100 + 1);
			numB = (int)(Math.random() * 100 + 1);
			System.out.println(numA + "+" + numB + "=  ?");
			value = scanner.nextInt();
			if(value == numA + numB) {
				count ++;
			}
			i++;
		}
		System.out.println("TRUE:" + count);
	}
	//6、有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
	@Test
	public void dome6() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				for (int x = 1; x < 5; x++) {
					if(i != j && i!=x && j!=x) {
						System.out.print(i*100 + j*10 + x +"\t");
					}
				}
				System.out.println();
			}
		}
	}
//	7、
//	   *
//	   **
//	   * *
//	   *  *
//	   *****
	@Test
	public void dome7() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				if(i>2) {
					if(j==1 || j==i || i == 5) {
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
//	8、
//	猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩
//			   下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下 
//			   的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。 
	/**
	 * 设 n
	 * 天	吃桃
	 * 1	n * 1/2 - 1							
	 * 2	(n * 1/2 - 1) * 1/2 - 1
	 * 3	((n * 1/2 - 1) * 1/2 - 1) * 1/2 - 1
	 * 4
	 * 5
	 * 6
	 * 7
	 * 8
	 * 9
	 * 10	****** = 1					第九天  * 1/2 - 1 = 1 ->> 第九题 = (盛 + 1) * 2  
	 */
	@Test
	public void dome8() {
		int all = 1;
		for (int i = 1; i <= 10; i++) {
			all = (all + 1) * 2;
		}
		System.out.println(all);
	}
	
	@Test
	public void dome88() {
		System.out.println(tao(10));
	}
	private int tao(int i) {
		if(i == 0) return 1;
		return (tao(i - 1) + 1) * 2;
	}
	
	
	
}
