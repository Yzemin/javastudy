package com.ziv.fog.creator.factorymodel.simplefactory;

interface Car{
	void run();
}
class Audi implements Car{
	public void run() {
		System.out.println("Audi");
	}
}
class Byd implements Car{
	public void run() {
		System.out.println("Byd");
	}
}
public class SimpleFactory {
	public static void main(String[] args) {
		CarFactory.create("audi").run();
	}
}
//	简单工厂
class CarFactory{
	public static Car create(String type){
		if("Audi".equalsIgnoreCase(type)){
			return new Audi();
		}else if("Byd".equalsIgnoreCase(type)){
			return new Byd();
		}else{
			return null;
		}
	}
	
	public static Audi createAudi(){
		return new Audi();
	}
	
	public static Byd createByd(){
		return new Byd();
	}
}