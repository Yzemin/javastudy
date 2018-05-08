package com.ziv.homework.day7; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月11日   上午9:21:24 
 * 类说明 :
 * 
*/

import java.util.Scanner;

import org.junit.Test;

public class Ziv {
//	1、定义一个可以存储10个元素的整型数组，并输出值。
	@Test
	public void strDome1() {
		int[] strs ={1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i]);
			if(i<strs.length-1)
				System.out.print(",");
		}
	}
//	2、定义一个6个长度数组，类型为int，求其中第二个元素和第四个元素的和是多少。
	@Test
	public void intDome2() {
		int[] arrays = {23,4,45,65,7,3};
		System.out.println(arrays[1]+arrays[3]);
	}
//	3、定义一个整型数组，求出数组元素的和、数组元素的最大值和最小值，并输出所求的结果。
	@Test
	public void IntegerDome3() {
		Integer[] arrays = {3,45,56,23,5,23,7,18,-12,-34,-64,40};
		Integer num = 0;
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] +"  ");
			num+=arrays[i];
		}
		Integer tempy = 0;
		for (int i = 0; i < arrays.length; i++) {
			tempy = arrays[i];
			for (int j = i; j < arrays.length; j++) {
				if(tempy < arrays[j]) {
					arrays[i] = arrays[j];
					arrays[j] = tempy;
					tempy = arrays[i];
				}
			}
		}
		System.out.println("\nALL: "+num+"\tMIN: "+arrays[arrays.length - 1]+"\tMAX: "+arrays[0]);
	}
//	4、int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
//		 	要求将oldArr数组中的0项去掉，将不为0的值存入一个新的数组，生成新的数组为:
//			int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5};
	@Test
	public void delZeroDome4() {
		int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		int newArr[]=new int[oldArr.length];
		int newnewArr[] = null;
		int index = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i] != 0) newArr[index++] = oldArr[i];
		}
		for (int i = 0; i < newArr.length; i++) {
			if(newArr[i]==0) {
				newnewArr = new int[i];
				break;
			}
		}
		
		for (int i = 0; i < newnewArr.length; i++) {
			newnewArr[i] = newArr[i];
		}
		for (int i = 0; i < newnewArr.length; i++) {
			System.out.print(newnewArr[i]+" ");
		}
	}
	@Test
	public void delZeroDome4New() {
		int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		int newArr[]= null;
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i]==0) {
				for (int j = i; j < oldArr.length; j++) {
					if(oldArr[j] != 0) {
						oldArr[i] = oldArr[j];
						oldArr[j] = 0;
						break;
					}
				}
			}
		}
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i] == 0) {
				newArr = new int[i];
				break;
			}
		}
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = oldArr[i];
			System.out.print(newArr[i]);
			if(i < newArr.length - 1) {
				System.out.print(",");
			}
		}
	}
//	5、定义一个包含10个元素的数组，对其进行赋值，使每个元素的值等于其下标，然后输出，最后将数组倒置后输出
	@Test
	public void laliDome5() {
		String[] strs = new String[10];
		for (int i = 0; i < strs.length; i++) {
			strs[i]=i+"";
		}
		for (int i = strs.length-1; i >= 0; i--) {
			System.out.print(strs[i]+" ");
		}
	}
	@Test
	public void laliDome5New() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int temp = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1) {
				System.out.print(",");
			}
		}
	}
//	6、             两个数组：
//		 	int a[][] = {{1,2},{3,4}};
//		 	int b[][] = {{5,6},{7,8}};
//		 	再创建一个数组c如图例得出结果：
//		 			6  8
//		 			10 12
//
	@Test
	public void dome6() {
		int a[][] = {{1,2},{3,4}};
	 	int b[][] = {{5,6},{7,8}};
	 	//	{{6,8},{10,12}}
	 	int c[][] = new int[2][2];
	 	for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + "  ");
			}
			System.out.println();
		}
	}
//	7、      婚礼上的谎言：三个新郎为A、B、C，三个新娘为X、Y、Z。
//		 有人想知道究竟谁和谁结婚，于是就问新人中的三位，得到如下提示：A说他将和X结婚；
//		 X说她的未婚夫是C，C说他将和Z结婚。这个人事后知道他们在开玩笑，全是假话，
//		 那么，究竟谁与谁结婚呢？
	/**
	 * A - X
	 * 		X - C
	 * 			C - Z
	 */
	@Test
	public void dome7() {
		
		String[] marry = new String[3];
		
		for (int i = 'A'; i <= 'C'; i++) {
			for (int j = 'X'; j <= 'Z'; j++) {
				marry[i - 'A'] = String.valueOf((char)i)+String.valueOf((char)j);
			}
		}
		
		for (int i = 0; i < marry.length; i++) {
			System.out.print(marry[i] + "\t");
		}
		
		for (int i = 'A'; i <= 'C'; i++) {
			for (int j = 'X'; j <= 'Z'; j++) {
				for (int z = 0; z < marry.length; z++) {
					if(j=='X') {
						if(i=='A'||i=='C')
							marry[z] = "";
					}
					if(i=='C') {
						if(j=='X'||j=='Z')
							marry[z] = "";
					}
				}
			}
		}
		
		for (int i = 0; i < marry.length; i++) {
			if(marry[i]!="") {
				System.out.print(marry[i] + "\t");
			}
		}
	}
	@Test
	public void dome7Old() {
		for (int i = 'A'; i <= 'C'; i++) {
			for (int j = 'X'; j <= 'Z'; j++) {
				if(j=='X') {
					if(i!='A'&&i!='C')
						System.out.print((char)i+""+(char)j+"\t");
				}
				if(i=='C') {
					if(j!='X'&&j!='Z')
						System.out.print((char)i+""+(char)j+"\t");
				}
			}
		}
	}
//	8、用随机数给一个整型数组赋值,并对数组求和。（范围自定） 
	@Test
	public void dome8() {		
		Scanner s = new Scanner(System.in);
		int i = 0;
		System.out.println("INPUT - i:");
		while(i <= 0) {
			i = s.nextInt();
		}
		int j = 0;
		System.out.println("INPUT - j:");
		while(j <= 0) {
			j = s.nextInt();
		}
		int a[][] = new int[i][j];
		int all = 0;
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[x].length; y++) {
				System.out.println("INPUT - value:");
				a[x][y] = s.nextInt();
				all+=a[x][y];
			}
		}
		System.out.println("ALL: " + all);
	}
//	9、十个同学，给每一个同学打分，通过运算，得到最高和最低分（用数组来做）
	@Test
	public void dome9() {
		int s[][] = new int[10][9];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < s.length; i++) {
			System.out.println("第"+(i+1)+"同學打分:");
			for (int j = 0; j < s[i].length; j++) {
				System.out.println("\t為第"+(j+1)+"打分");
				while(true) {
					s[i][j] = sc.nextInt();
					if(s[i][j]>100||s[i][j]<0) {
						System.out.println("\t為第"+(j+1)+"打分,重新打分");
						s[i][j] = sc.nextInt();
					}
				}
			}
		}
		int a[] =new int[10];
		for (int i = 0,all = 0; i < s.length; i++,all=0) {
			for (int j = 0; j < s[i].length; j++) {
				all+=s[i][j];
			}
			a[i] = all;
		}
		int min =a[0];
		int max=a[0];
		for (int i = 1; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.min(max, a[i]);
		}
		System.out.println("MIN: "+min+"MAX: "+max);
	}
}
 