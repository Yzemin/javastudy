package com.ziv.homework.day5;

public class Day4Homework {
	private static int i = 0;
	public static void main(String[] args) {
		getRandom(Math.random());
		//random();
	}
	
	private static void random(){
		int number = (int)(0.99999999_99999999_44488848_78 * 3);
		System.out.println(number);
		System.out.println((int)(0.99999999_99999999_44488848_77 * 3));
		number = (int) Math.floor(Math.random()*3);
		System.out.println(number);
		System.out.println(Math.random());
	}
	
	private static void getRandom(double db){
		if(db > 0.9999_9999_9999_9999){
			System.out.println(db);
		}else{
			i++;
			System.out.println(String.valueOf(db).length());
			try {
				getRandom(Math.random());
			} catch (Exception e) {
				System.out.println(i);
			}
		}
		
	}
}
