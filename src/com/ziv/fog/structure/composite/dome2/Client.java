package com.ziv.fog.structure.composite.dome2;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5,f6;
		Folder f1 = new Folder("我的文件夹");
		f2 = new ImageFile("咯奥格.jpg");
		f3 = new TestFile("xx.txt");
		f1.add(f2);
		f1.add(f3);
		f1.killVirus();
	}
}
