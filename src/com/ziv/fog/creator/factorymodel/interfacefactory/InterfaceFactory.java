package com.ziv.fog.creator.factorymodel.interfacefactory;

interface Car{
	void run();
}
interface CarFactory{
	Car createCar();
}

class AudiFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Audi();
	}
	
}
class BydFactory implements CarFactory{

	@Override
	public Car createCar() {
		return new Byd();
	}
	
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
public class InterfaceFactory {
	public static void main(String[] args) {
		Car audi = new AudiFactory().createCar();
		Car byd = new BydFactory().createCar();
		audi.run();
		byd.run();
	}
}