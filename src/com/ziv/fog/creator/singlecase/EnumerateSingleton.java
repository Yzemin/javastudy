package com.ziv.fog.creator.singlecase;
/**
 * @author ziv
 * 创建者单例模式 -》饿汉方式 -> 枚举
 *  无延迟加载，立即加载
 */
public enum EnumerateSingleton {
	
	INSTANCE;
	
	public void singletonOperation(){
		
	}
}
