package com.ziv.fog.structure.bridge.dom2;

public class Computer {
	protected Brand brand;
	public Computer(Brand brand) {
		this.brand = brand;
	}
	public void sale(){
		brand.sale();
	}
}

class Desktop extends Computer{

	public Desktop(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("Desktop");
	}
	
}

class Top extends Computer{

	public Top(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("Desktop");
	}
	
}