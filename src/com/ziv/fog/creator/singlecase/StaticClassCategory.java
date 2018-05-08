package com.ziv.fog.creator.singlecase;
/**
 * @author ziv
 * 创建者单例模式 -》单例懒汉式-> 静态类部类
 *  延时加载
 *		
 */
public class StaticClassCategory {
	
	private static class StaticClassCategoryInstance{
		private static final StaticClassCategory staticClassCategory = new StaticClassCategory();
	}
	
	public static StaticClassCategory getInstance(){
		return StaticClassCategoryInstance.staticClassCategory;
	}
	
	private StaticClassCategory(){
		
	}
}
