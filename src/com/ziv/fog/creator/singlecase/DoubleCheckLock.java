package com.ziv.fog.creator.singlecase;
/**
 * @author ziv
 * 创建者单例模式 -》单例懒汉式  -> 双重检查锁
 * 立即加载
 * 		双重检查锁
 * 		仅仅 类为空时才 实现单线程加载
 * 	
 * 		jVM 内部不和 会出一些问题
 *
 */
public class DoubleCheckLock {
	private static DoubleCheckLock doubleCheckLock= null;
	private DoubleCheckLock() {
	}
	//	synchronized -> 避免多线程时的并发
	public static DoubleCheckLock getInstance(){
		if(null == doubleCheckLock){
			DoubleCheckLock dcls;
			synchronized (DoubleCheckLock.class) {
				dcls = doubleCheckLock;
				if(null == dcls){
					dcls = new DoubleCheckLock();
				}
			}
			doubleCheckLock = new DoubleCheckLock();
		}
		return doubleCheckLock;
	}
}
