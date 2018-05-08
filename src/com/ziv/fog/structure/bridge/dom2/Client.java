package com.ziv.fog.structure.bridge.dom2;

public class Client {
	public static void main(String[] args) {
		Computer c=new Top(new Lenovo());
		c.sale();
	}
}
