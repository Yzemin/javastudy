package com.ziv.fog.creator.singlecase;
/**
 * @author ziv
 * 创建者单例模式 -》单例饿汉式
 *	立即加载
 *
 */
public class OneCaseWhoType {
	private static OneCaseWhoType oneCaseWhoType = new OneCaseWhoType();
	private OneCaseWhoType(){
		
	}
	public static OneCaseWhoType getInstance(){
		return oneCaseWhoType;
	}
}
