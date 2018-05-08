package com.ziv.fog.structure.bridge.dom1;

public class BridgeDome1 {
	
}
interface Computer{
	void sale();
}
class Desktop implements Computer{

	@Override
	public void sale() {
		System.out.println("台式机");
	}
	
}
class Laptop implements Computer{

	@Override
	public void sale() {
		System.out.println("台式机");
	}
	
}
class Pad implements Computer{

	@Override
	public void sale() {
		System.out.println("台式机");
	}
	
}
class LenovoDesktop extends Desktop{

	@Override
	public void sale() {
		System.out.println("LenovoDesktop");
	}
	
}