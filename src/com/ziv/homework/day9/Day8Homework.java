package com.ziv.homework.day9;

import java.util.Scanner;

/**
 * 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月23日   下午6:01:57 
 * 类说明 :
 *
 */
public class Day8Homework {
	public static void main(String[] args) {

		String[][] str = new String[2][3];
		int num = 0;
		int index = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("**歡迎使用八重齒0.0.1版 ATM**");
		while (true) {
			System.out.println("\n1.登陸\n2.注冊\n3.退出\n-->");
			String op = scanner.next();
			boolean wanwan = false;
			if ("3".equals(op)) {
				System.out.println("親，再見!");
				break;
			} else if ("2".equals(op)) {
				System.out.println("********注冊********\n3.退出");
				while (true) {
					if (num < 2) {
						boolean bool = false;
						
						
						while(true) {
							System.out.println("請輸入用戶名((3,10])\n-->");
							String name = scanner.next();
							if ("3".equals(name)) {
								System.out.println("*********\n**********");
								bool = true;
								break;
							}
							if (!name.isEmpty()) {
								if (!name.contains(" ")) {
									if (name.length() > 3 && name.length() <= 10) {
										str[num][0] = name;
										break;
									} else {
										System.out.println("用戶名不在（3，10】範圍類\n********************\n重新注冊");
									}
								} else {
									System.out.println("用戶名中不能包括空格\n********************\n重新注冊");
								}
							} else {
								System.out.println("用戶名不爲空\n");
							}
						}
						
						if(bool) {
							break;
						}
						
						while(true) {
							System.out.println("請輸入密碼(必須是6個數字)\n-->");
							String pwd = scanner.next();
							if ("3".equals(pwd)) {
								System.out.println("*********\n**********");
								bool = true;
								break;
							}
							if (!pwd.isEmpty()) {
								if (!pwd.contains(" ")) {
									if (pwd.length() == 6) {
										str[num][1] = pwd;
										str[num][2] = 0 + "";
										num++;
										bool = true;
										break;
									} else {
										System.out.println("密碼必須是6個數字範圍類\n********************\n重新注冊");
									}
								} else {
									System.out.println("密碼中不能包括空格\n********************\n重新注冊");
								}
							} else {
								System.out.println("密碼不爲空\n");
							}
						}
						
						if(bool) {
							break;
						}
						
						
					} else {
						System.out.println("本系統衹能注冊兩個");
						break;
					}
				}
			} else if ("1".equals(op)) {
				int count = 3;
				while(true) {
					
					for (int i = 0; i < str.length; i++) {
						for (int j = 0; j < str[i].length; j++) {
							System.out.println(str[i][j]+" ");
						}
					}
					
					System.out.println("請輸入用戶名：->");
					String name = scanner.next();
					System.out.println("請輸入密碼：->");
					String pwd = scanner.next();
					if(str[0][0].trim().equals(name.trim()) && str[0][1].trim().equals(pwd.trim())) {
						index = 0;
						break;
					} else if(str[1][0].trim().equals(name.trim()) && str[1][1].trim().equals(pwd.trim())) {
						index = 1;
						break;
					} else {
						System.out.println("用戶名或密碼錯誤！");
						System.out.println("重新登陸");
						System.out.println("*****************");
						count -- ;
						if(count == 0) {
							System.out.println("三次，密碼錯誤，你的卡失效");
							wanwan  = true;
							break;
						}
					}
				}
				
				boolean bool = false;
				while(true) {					
					System.out.println("\n1.存錢\n2.取錢\n3.轉賬\n4.修改密碼\n5.查詢余額\n6.退出\n-->");
					op = scanner.next();
					if("6".equals(op)) {
						System.out.println("**********\n**********");
						bool = true;
						break;
					} else if("1".equals(op)) {
						System.out.println("請輸入存錢的多少\n->");
						str[index][2] = Double.parseDouble(str[index][2]) + scanner.nextDouble() + "";
					} else if("2".equals(op)) {
						System.out.println("請輸入取多少錢\n->");
						double db = scanner.nextDouble();
						double mdb = Double.parseDouble(str[index][2]);
						if(mdb > db) {							
							str[index][2] = mdb - db + "";
						}else {
							System.out.println("失敗");
						}
					} else if("3".equals(op)) {
						System.out.println("請輸入轉賬的賬戶->");
						if(index == 0) {
							if(scanner.next().equals(str[1][0].trim())) {
								System.out.println("金額->");
								double db = scanner.nextDouble();
								double mdb = Double.parseDouble(str[0][2]);
								if(mdb > db) {							
									str[0][2] = mdb - db + "";
									str[1][2] = Double.parseDouble(str[1][2]) + db + "";
								}else {
									System.out.println("失敗");
								}
							}else {
								System.out.println("賬戶不存在");
							}
						} else if(index == 1) {
							if(scanner.next().equals(str[0][0].trim())) {
								System.out.println("金額->");
								double db = scanner.nextDouble();
								double mdb = Double.parseDouble(str[1][2]);
								if(mdb > db) {							
									str[1][2] = mdb - db + "";
									str[0][2] = Double.parseDouble(str[0][2]) + db + "";
								}else {
									System.out.println("失敗");
								}
							}else {
								System.out.println("賬戶不存在");
							}
						}
						
					} else if("4".equals(op)) {
						System.out.println("請輸入新的密碼");
						System.out.println("請輸入密碼(必須是6個數字)\n-->");
						String pwd1 = scanner.next();
						if (!pwd1.isEmpty()) {
							if (!pwd1.contains(" ")) {
								if (pwd1.length() == 6) {
									str[index][1] = pwd1;
									break;
								} else {
									System.out.println("密碼必須是6個數字範圍類\n********************\n重新注冊");
								}
							} else {
								System.out.println("密碼中不能包括空格\n********************\n重新注冊");
							}
						} else {
							System.out.println("密碼不爲空\n");
						}
					} else if("5".equals(op)) {
						System.out.println(str[index][2]);
					}
				}
				
				if(bool) {
					break;
				}
				
			} else {
				System.out.println("親！你説什麽!");
			}
			if(wanwan) {
				break;
			}
		}
	}
}
