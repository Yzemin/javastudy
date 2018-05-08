package com.ziv.clazz.prop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

interface Name{
	public void println(String str);
}

class User implements Name {
	User(){
		System.out.println("NEW: USER");
	}
	public void println(String str){
		System.out.println("USER: " + str);
	}
}

class Admin implements Name {
	Admin(){
		System.out.println("ADMIN:　ADMIN");
	}
	public void println(String str){
		System.out.println("ADMIN:" + str);
	}
}

public class Prop {
	 public static void main(String[] args) throws Exception {
		 {
			 //	create properties
			 Properties pro = new Properties();
			 pro.setProperty("prop.class", "com.ziv.clazz.prop.Admin");
			 pro.store(new FileOutputStream(new File("info.properties")), "I am Ziv !");
		 }
		 {
			 //	read properties
			 Properties pro = new Properties();
			 pro.load(new FileInputStream(new File("info.properties")));
			 System.out.println(pro.getProperty("prop.class"));
		 }
	}
}
