package com.ziv.homework.day4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day4 {
	public static void main(String[] args) {
		homework2();
	}

	@SuppressWarnings({ "resource" })
	private static String input(String str) {
		if(str != null) println(str);
		return new Scanner(System.in).next();
	}
	
	private static void println(String str){
		System.out.println(str);
	}
	
	private static void println(double d){
		String s = String.valueOf(d);
		int index = s.lastIndexOf(".");
		int value = Integer.parseInt(s.substring(index+1, s.length()));
		if(value == 0)
			System.out.println(s.substring(0, index));
		else
			System.out.println(d);
	}
	
	private static void print(char str){
		System.out.print(str);
	}
	
	private static void print(String str){
		System.out.print(str);
	}
	
	private static void homework2(){
		{
			println("--------------------------------");
			//5、从键盘输入2个数和一个运算符(+,-,*,/)，输出运算结果（switch语句写）
			println("---- input two number And Carcl!------");
			double a = Double.parseDouble(input("input frist number: "));
			double b = Double.parseDouble(input("input secend number: "));
			String str = input("input Opector: ");
			print(a + str + b + " = ");
			switch(str){
			case "+":
				println(a+b);
				break;
			case "-":
				println(a-b);
				break;
			case "*":
				println(a*b);
				break;
			case "/":
				if(b == 0) break;
				println(a/b);
				break;
			default:
				println("error!");
				break;
			}
		};
		{
			println("--------------------------------");
			//6、根据输入的月份，判断该月份有多少天
			boolean bool = true;
			int m = 0;
			while (bool) {
				m = Integer.parseInt(input("input a Month: "));
				if(m > 0 && m <= 12) break;
				println("error - again ! ---");
			}
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				println("this month have 31");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				println("this month have 30");
				break;
			case 2:
				println("maybe 29 or 28 ! I Donwn't not!");
				break;
			default:
				println("error!");
				break;
			}
			
		};
		{
			println("--------------------------------");
			//7、给一个不多于5位的正整数，要求：1. 求出它是几位数 2. 按逆序打印出各位数字，例如原数是321，应输出123。
			String str = input("给一个不多于5位的正整数:");
			int i = str.length();
			if(i > 5 ){
				println("error!");
			}else{
				int num = Integer.parseInt(str);
				if(num>0){
					if(num<10){
						println("1  位数----");
					}else if(num<100){
						println("2  位数----");
					}else if(num<1000){
						println("3  位数----");
					}else if(num<10000){
						println("4  位数----");
					}else if(num<100000){
						println("5  位数----");
					}else{
						println("error!");
					}
					
					str = String.valueOf(num);
					print(str.charAt(--i));
					if(i>0){
						print(str.charAt(--i));
					}
					if(i>0){
						print(str.charAt(--i));
					}
					if(i>0){
						print(str.charAt(--i));
					}
					if(i>0){
						print(str.charAt(--i));
					}
					if(i>0){
						print(str.charAt(--i));
					}
					if(i>0){
						print(str.charAt(--i));
					}
				}else{
					println("error!");
				}
				
			}
		};
		{
			println("--------------------------------");
			//8、输入一个数字，判断它能否被3、5、7整除 （注意考虑同时整除的情况）
			double a = Double.parseDouble(input("输入一个数字，判断它能否被3、5、7整除 （注意考虑同时整除的情况）:"));
			if(a%3==0){
				println("判断它能被3整除 !");
			}
			if(a%5==0){
				println("判断它能被5整除 !");
			}
			if(a%7==0){
				println("判断它能被7整除 !");
			}
			if(a%3==0&&a%5==0&&a%7==0){
				println("判断它能被3,5,7整除 !");
			}
		};
		

//9、研究一下Date类和SimpleDateFormat类
	}
	
	private static void homework1(){
		{
			boolean bool = 10>9&19>18;
			System.out.println(bool);
			bool = 9>10&&19>18;
			System.out.println(bool);
			
		};
		{
			String str = "asbsda123+54qweq";
			Matcher m = Pattern.compile("\\d").matcher(str);
			StringBuffer resStr = new StringBuffer();
			
			while(m.find()){
				resStr = resStr.append(m.group());
			}
			System.out.println(Integer.parseInt(resStr.toString()) * 3);
		}
		{
			String str = "asbsda123+54qweq";
			str = str.substring(6, 9);
			System.out.println(Integer.parseInt(str) * 3);
		}
		{
			//1、编程输入整数a和b，若a或b大于100，则输出a,b的和与100的差，否则输出两数之和。
			println("--- input plase two number ---");
			int a = Integer.valueOf(input("number one: "));
			int b = Integer.valueOf(input("number two: "));
			if(a<=100 || b<=100)
				println("a + b = " + (a+b));
			else
				println("a + b - 100 =" + (a+b-100) );
		};
		{
			//2.信用卡账单出来了，如果账单超过5000 我只得去找个新工作，否则我会继续现在的工作。
			println("--- 信用卡账单出来了， ---");
			double a = Double.parseDouble(input("number one: "));
			if(a >= 5000)
				println("我只得去找个新工作");
			else
				println("我会继续现在的工作");
		};
		{
			//3、从键盘输入三角形的三边长，判断出这三边能否构成三角形。
			println("--- input plase three number ---");
			int a = Integer.valueOf(input("number one: "));
			int b = Integer.valueOf(input("number two: "));
			int c = Integer.valueOf(input("number three: "));
			if(a+b>c && a+c>b && b+c>a && a-b<c && a-c<b && b-c<a && b-a<c && c-a<b && c-b<a){
				println("can构成三角形");
			}else
				println("否构成三角形");
		};
		{
			//4、控制台输入分数，分别使用三目运算和if语句判断该分数是否及格。
			println("--- input plase one number --> page ---");
			int a = Integer.valueOf(input("number one: "));
			if( a>100) println("XXXXX");
			else if(a>=60) println("分数是及格");
			else println("分数否及格");
			//-a>=60?println("分数是及格"):println("分数是及格");
		};
	}
}
