package com.ziv.homework.day8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import javax.tools.JavaFileManager.Location;

import org.junit.Test;

public class Ziv {

	@Test
	public void dome1(){
		int[] arrays = new int[100];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = i+1;
		}
		for (int i : arrays) {
			if(i%2==0)
				System.out.print(i+"\t");
			if(i%10==0){
				System.out.println();
			}
		}
	}
	
	@Test
	public void dome2(){
		String next;
		Scanner scanner = new Scanner(System.in);
		double[] db = new double[2];
		int i = 0;
		System.out.println("0.0 -> 退出");
		while(true){
			next = scanner.next();
			if("0.0".equals(next)){
				break;
			}else {
				try {	
					db[i] = Double.parseDouble(next);
					i++;
				} catch (Exception e) {
					db = Arrays.copyOf(db, db.length +2 );
					db[i] = Double.parseDouble(next);
					i++;
				}
			}
		}
		for (double d : db) {
			System.out.print(d+"\t");
		}
	}
	
	@Test
	public void dome3(){
		double[] db =new double[50];
		for (int i = 0; i < db.length; i++) {
			db[i] = Double.parseDouble(String.format("%.2f", Math.random()*9));
		}
		double[] max={0,0},min ={0,0};
		for (int i = 0; i < db.length; i++) {
			if(i==0){
				max[0] = db[i];
				max[1] = 1;
				min[0] = db[i];
				min[1] = 1;
			}
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(db[i]+"\t");
			if(max[0] < db[i]){
				max[0] = db[i];
				max[1] = 1;
			}else if(max[0] - db[i] < 0.00000001){
				max[1]+=1;
			}
			if(min[0] > db[i]){
				min[0] = db[i];
				min[1] = 1;
			}else if(db[i] - min[0] < 0.00000001){
				min[1]+=1;
			}
		}
		System.out.println("\nMAX: "+max[0]+", "+(int)(max[1])+", "+(max[1]/db.length)+"\tMIN: "+min[0]+", "+(int)(min[1])+", "+(min[1]/db.length));
	}
	
	@Test
	public void dome3NewInt(){
		int[] db =new int[50];
		String str = "";
		for (int i = 0; i < db.length; i++) {
			db[i] =  (int)(Math.random()*10);
		}
		for (int i = 0; i < db.length; i++) {
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(db[i] + "\t");
		}
		System.out.println("\n------------------------------------------------------------------------");
		Arrays.sort(db);
		for (int i : db) {
			str+=i;
		}
		for (int i = 0; i < db.length; i++) {
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(db[i] + "\t");
		}
		System.out.println("\n------------------------------------------------------------------------");
		int[] cc = new int[10];
		System.out.println(str);
		System.out.println("\n------------------------------------------------------------------------");
		for (int i = 0; i < 10; i++) {
			cc[i] = str.length()-str.replaceAll(i+"","").length();
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(i+"->"+cc[i] + "\t");
		}
		int[] bb = Arrays.copyOf(cc, cc.length);
		Arrays.sort(cc);
		for (int i = 0; i < bb.length; i++) {
			if(cc[0] == bb[i]){
				System.out.println("\nMIN: "+i+"\tCOUNT: "+ cc[0] +"\tP: "+i/50.0);
			}
			if(cc[cc.length-1] == bb[i]){
				System.out.println("\nMAX: "+i+"\tCOUNT: "+ cc[cc.length-1] +"\tP: "+i/50.0);
			}
		}
	}
	
	@Test
	public void dome3NewDouble(){
		double[] db =new double[50];
		String str = "";
		for (int i = 0; i < db.length; i++) {
			db[i] =  Double.parseDouble(String.format("%.2f", Math.random()*10));
		}
		for (int i = 0; i < db.length; i++) {
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(db[i] + "\t");
		}
		System.out.println("\n------------------------------------------------------------------------");
		Arrays.sort(db);
		for (double i : db) {
			str=str+"|"+i;
		}
		System.out.println(str);
		System.out.println("\n------------------------------------------------------------------------");
		for (int i = 0; i < db.length; i++) {
			if(i>0&&i%10==0){
				System.out.println();
			}
			System.out.print(db[i] + "\t");
		}
	}
	
	@Test
	public void dome4(){
		/**
		 * 100 + 100/2*2 + (100/2*2)/2*2 + 
		 * 100 + 50 * 2 + 25*2
		 * 100   50   25  12.5  6.25  3.125  + 1.5625 + 0.78125 + 0.390625 + 0.1953125
		 * 100   100  50  25    12.5  6.25   + 3.125 + 1.5625 + 0.78125  + 0.1953125
		 *  287.5 + 6.25
		 */
		double lang = 100,all = 100;
		for (int i = 9; i > 0; lang = lang / 2.0,i--) {
			all += lang;
		}
		System.out.println(lang);
		System.out.println(all);
//		System.out.println(100+100+50+25+12.5+6.25+3.125+1.5625+0.78125+ 0.1953125);
		
	}
	
	
	
	
	
	
	
	
	
	
}
