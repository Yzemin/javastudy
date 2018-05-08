package com.ziv.fog.structure.bridge.dom2;

public interface Brand {
	void sale();
}
class Lenovo implements Brand{

	@Override
	public void sale() {
		System.out.println("Lenovo sale");
	}
	
}