package com.ziv.homework.day5;

import java.awt.Color;
import java.util.Scanner;


public class Loop {
	
	public static void main(String[] args) {
		/*
		 *          **                                 **
		 * 	        **        *********************     ** 
		 * 	        **        *******************        **  ***********************
		 *          **                        **          **  *******************
		 *	********************            **                **               **
		 *  ********************          **           **         **       **
		 *        ******        *************           **            ****
		 *       ** ** **       **************           **          **  **
		 *      **  **  **          **    **  **          **      **         **
		 *     **   **   **        **    **    **          ** ***               **
		 *    **    **    **     **     **     **            ***                   **
		 *   **     **     **   **     **      **            **
		 *  **      **      ** **     **  *   **            **
		 *          **        **          **  **          **
		 *          **                     **           **
		 *  
		 */
	}
	
	public static void printNum(){
		int i = 1;
		for (; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println("count:" + (--i));
	}
	
	public static void printDown(){
		for (int i = 10; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void printOut(){
		String str = "";
		for (int i = 1; i < 100; i++) {
			if(i%3 != 0){
				str =str + "  "+ i;
			}
		}
		System.out.println(str);
	}
//	4.计算机随机产生1~50之间的数字，如果生成的数字为33，则退出，统计一共执行了多少次
	public static void printOutthree(){
		boolean bool = true;
		int count = 0;
		while(bool){
			int rd = (int)(Math.random()*50)+1;
			++count;
			if(rd == 33){
				bool = false;
			}
		}
		System.out.println(count);
	}
//	5.输出1~100，每五个数字换一行
	public static void printOnehrade(){
		for(int i = 1;i<=100;i++){
			System.out.print(i+"  ");
			if(i%5 == 0){
				System.out.println();
			}
		}
	}
//	6.
//	      *			1-0	0
//	     ***		3-1	1
//	    *****		5-2	2
//	   *******		7-3	3
//	  *********		9-4	4
//	   *******		7-4 
//	    *****		5-3
//	     ***		3-2	
//	      *			1-1
	public static void printLinxin(){
		for(int i = 0;i<5;i++){
			for (int j = 4-i;j>0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 4;i >0 ;i--){
			for (int j = 5-i;j>0; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
//	7、
//	  **********
//	  *        *
//	  *        *
//	  *        *
//	  *        *
//	  *        *
//	  *        *
//	  *        *
//	  *        *
//	  **********
	public static void printZheng(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(i==0 || i==9){
					System.out.print("*");
				}else{
					if(j==0 || j==9){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void printUser(){
		System.out.println("*****************WECOMLE****************");
		boolean bool = true;
		Scanner scanner = new Scanner(System.in);
		String name = "";
		String pwd = "";
		while(bool){
			System.out.println("NAME:");
			name = scanner.next();
			System.out.println("PWD:");
			pwd = scanner.next();
			while(bool){				
				System.out.println("Y/N");
				String ok = scanner.next();
				if("Y".equalsIgnoreCase(ok)){
					System.out.println("NAME: " + name+"\nPWD: "+pwd);
					bool = false;
				}else if("N".equalsIgnoreCase(ok)){
					break;
				}
			}
		}
	}
	
}
