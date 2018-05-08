package com.ziv.homework.day6;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Day5Homework {
	
//	1.计算机随机产生一个数，用户进行猜数。值到猜正确为止。（1-20）
	@Test
	public void dome1(){
		int num = 0 , count = 0 ,randomNum = 0;
		println("计算机随机产生一个数，用户进行猜数。值到猜正确为止。（1-20）");
		while(true) {
			println("请输入你猜的数字：");
			num = scannerIntegter();
			randomNum = (int) (Math.random()*20+1);
			count ++;
			print("你猜的数是：" + num + "，电脑显示的数是：" + randomNum);
			if(num == randomNum) {
				println("\t恭喜你猜对了！");
				println("你一共猜了："+count+"次!");
				break;
			}else {
				println("\t你猜错了！");
			}
		}
		
	}
	
//	2.判断一下1-10000之间有多少个7的倍数
	@Test
	public void dome2() {
		int i = 1 ;
		while(i*7<=10000) {
			++i;
		}
		println("1-10000之间有 "+i+" 个7的倍数");
	}
//			
//	3.算水仙花数（100-999）：表示三位数的数字，个位的三次方+十位的三次方+百位的三次方=这个数本身
	@Test
	public void dome3() {
		int i = 100;
		while(i<1000) {
			if(i == Math.pow((int)(i/100), 3) + 
					Math.pow((int)(i/10%10), 3) + Math.pow((int)(i%10), 3)) {
				print(i + "  ");
			}
			++ i;
		}
	}
//	4.输出九九乘法表
	@Test
	public void dome4() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				print(i + "*" + j + "=" +(i*j) +"  ");
			}
			println("");
		}
	}
//	5.输入一个数，判断该数字是否为素数（质数）
	//	质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
	@Test
	public void dome5() {
		println("请输入一个数:");
		int num = scannerIntegter();
		if(num>1) {
			int i = 2;
			while(i<=num) {
				if(i == num) {
					println("该数是素数（质数）");
					break;
				}
				if(num % i == 0) {
					println("该数已经被"+i+"整除,该数不是素数（质数）");
					break;
				}
				++i;
			}
		}else {
			println("该数不大于一不是素数（质数）");
		}
	}
//
//	6.输入五个数，通过运算，求出其中的最大值或最小值
	@Test
	public void dome6() {
		int i = 1;
		double[] db = new double[5];
		Scanner scanner = new Scanner(System.in);
		while(i<6) {
			print("请输入第"+i+"个数:");
			db[i-1] = scanner.nextDouble();
			++i;
		}
		Arrays.sort(db);
		println("MIN: "+ delZero(db[0]) +"   MAX:" + delZero(db[db.length -1]));
	}
	private Object delZero(double db) {
		if(".0".equals(String.valueOf(db).substring(String.valueOf(db).lastIndexOf(".")))) {
			return Integer.parseInt(String.valueOf(db).substring(0,String.valueOf(db).lastIndexOf(".")));
		}
		return db;
	}
	
	private static void print(Object obj) {
		System.out.print(obj);
	}
	private static void println(Object obj) {
		System.out.println(obj);
	}
	
	private static int scannerIntegter(){
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
