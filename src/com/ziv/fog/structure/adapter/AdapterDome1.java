package com.ziv.fog.structure.adapter;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月19日   下午8:58:19 
 * 类说明 :
 * 		結構模式 - 適配器模式
*/
interface AdapterTarget1{
	void handleReq();
}
//	帶適配的對象
class Adapter1{
	public void request() {
		System.out.println("要完成操作的功能");
	}
}
//	USB
class Client {
	public void test1(AdapterTarget1 t) {
		t.handleReq();
	}
}

class AdapterMain2 implements AdapterTarget1{
	private Adapter1 adapter1;
	public AdapterMain2(Adapter1 adapter1){
		this.adapter1 = adapter1;
	}
	@Override
	public void handleReq() {
		adapter1.request();
	}
	
}

class AdapterMain1 extends Adapter1 implements AdapterTarget1 {
	
	@Override
	public void handleReq() {
		super.request();
	}
}

public class AdapterDome1 {
	
	public static void main(String[] args) {
		testAdapterMain1();
		testAdapterMain2();
	}
	
	public static void testAdapterMain1() {
		Client c = new Client();
		Adapter1 a = new Adapter1();
		AdapterTarget1 t = (AdapterTarget1) new AdapterMain1();
		
		c.test1(t);
	}
	
	public static void testAdapterMain2() {
		Client c = new Client();
		Adapter1 a = new Adapter1();
		AdapterTarget1 t = (AdapterTarget1) new AdapterMain2(a);
		
		c.test1(t);
	}
}
 