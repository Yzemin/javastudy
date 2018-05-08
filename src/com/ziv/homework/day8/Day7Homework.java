package com.ziv.homework.day8;

import org.junit.Test;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月11日   下午5:18:59 
 * 类说明 :
 * 
*/
public class Day7Homework {
//	1、 三个同学四门课程,输入每个课程的成绩，使用到二维数组
// 		求每个同学的平均分
// 		求每门课程的平均分
// 		求所有成绩中的最高分
// 		求所有成绩中100分有几个。
	@Test
	public void dome1() {
		double[][] dbs = new double[3][6];
		int count = 0;
		double arg = 0,max = 0;
		System.out.println("同學\t\t成績1\t成績2\t成績3\t成績4\t最高分\t平均分");
		for (int i = 0; i < dbs.length; i++) {
			System.out.print("同學"+(i +1) +": \t\t");
			arg = 0;
			max = 0;
			for (int j = 0; j < dbs[i].length - 2; j++) {
				dbs[i][j] = Double.parseDouble(
						String.format("%.2f", Math.random() *  101).toString());
				if(dbs[i][j] == 100 || dbs[i][j] > 99.99) {
					count++;
				}
				arg = dbs[i][j] + arg;
				System.out.print(dbs[i][j] + "\t");
				max = Math.max(max, dbs[i][j]);
			}
			dbs[i][4] = max;
			dbs[i][5] = Double.parseDouble(String.format("%.3f",arg / 4.0).toString());
			System.out.print(dbs[i][4] + "\t" + dbs[i][5]);
			System.out.println();
		}
		System.out.print("每個課程平均分:\t");
		
		for (int i = 0; i < dbs[0].length - 1; i++) {
			arg = 0;
			max = 0;
			for (int j = 0; j < dbs.length; j++) {
				if(i == dbs[0].length - 2) {
					max = Math.max(max, dbs[j][i]);
				}else {					
					arg = dbs[j][i] + arg;
				}
			}
			if(i == dbs[0].length - 2) {
				System.out.print(max +"(所有成绩中的最高分)");
			}else {				
				System.out.print(Double.parseDouble(String.format("%.3f",arg / 3.0).toString()) + "\t");
			}
		}
		System.out.println("\n--------成绩中100分有 : "+ count+" 个");
	}
	
//2、使用随机数给一个10个元素的一维数组赋值,对10个整数排序（从小到大）。
	@Test
	public void dome2() {
		double[] dbs = new double[10];
		for (int i = 0; i < dbs.length; i++) {
			if(Math.random() > 0.5) {		
				dbs[i] = Double.parseDouble(
						String.format("%.2f", Math.random() *  -(int)(Math.random() * 10)).toString());
			}else {
				dbs[i] = Double.parseDouble(
						String.format("%.2f", Math.random() *  (int)(Math.random() * 10)).toString());
			}
		}
		
		for (int i = 0; i < dbs.length; i++) {
			System.out.print(dbs[i] + "\t");
		}
		System.out.println();
		double tempy = 0;
		for (int i = 0; i < dbs.length; i++) {
			tempy = dbs[i];
			for (int j = i + 1; j < dbs.length; j++) {
				if(dbs[i] > dbs[j]) {
					dbs[i] = dbs[j];
					dbs[j] = tempy;
					tempy = dbs[i];
				}
			}
		}
		for (int i = 0; i < dbs.length; i++) {
			System.out.print(dbs[i] + "\t");
		}
	}
}
 