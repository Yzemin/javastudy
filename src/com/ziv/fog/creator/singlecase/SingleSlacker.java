package com.ziv.fog.creator.singlecase;
/**
 * @author ziv
 * 创建者单例模式 -》单例懒汉式
 *  延迟加载
 *		每次调用 getInstance 都是单线程，速度慢
 */
public class SingleSlacker {
	private static SingleSlacker singleSlacker= null;
	private SingleSlacker() {
	}
	//	synchronized -> 避免多线程时的并发
	public static synchronized SingleSlacker getInstance(){
		if(null == singleSlacker){
			singleSlacker = new SingleSlacker();
		}
		return singleSlacker;
	}
}
