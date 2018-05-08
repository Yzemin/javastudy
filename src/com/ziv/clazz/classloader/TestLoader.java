package com.ziv.clazz.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 作者 E-mail: ziv 八重齿 @2374619909.com
 * @version 创建时间： 2018年4月8日 下午8:35:31 类说明 :
 * 
 */
class MyLoader extends ClassLoader {
	public Class<?> getClass(String name) {
		byte[] data = null;
		try {
			data = this.loadNetFile(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.defineClass(name, data, 0, data.length);
	}

	public byte[] loadClassFile(String name) throws Exception {
		String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
		String filePath = "E:" + fileName;

		File file = new File(filePath);
		InputStream input = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte data[] = new byte[1024];
		int len = 0;
		while ((len = input.read(data)) != -1) {
			baos.write(data, 0, len);
		}
		input.close();
		baos.close();
		return baos.toByteArray();
	}

	public byte[] loadNetFile(String name) throws Exception {
		String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
		URL url = new URL("http://127.0.0.1/" + fileName);
		URLConnection conn = url.openConnection();
		InputStream input = conn.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte data[] = new byte[1024];
		int len = 0;
		while ((len = input.read(data)) != -1) {
			baos.write(data, 0, len);
		}
		input.close();
		baos.close();
		return baos.toByteArray();
	}
}

public class TestLoader {
	public static void main(String[] args) throws Exception {
		MyLoader load = new MyLoader();
		Class<?> cls = load.getClass("com.ziv.vo.Book");
		System.out.println(cls.newInstance());
	}
}
