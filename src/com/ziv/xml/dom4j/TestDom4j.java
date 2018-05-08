package com.ziv.xml.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author 作者 E-mail: ziv 八重齿 @2374619909.com
 * @version 创建时间： 2018年4月10日 上午10:02:44 类说明 :
 * 
 */
public class TestDom4j {
	public static void main(String[] args) throws Exception {
		add();
	}

	public static void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/com/ziv/xml/myxml.xml");
		Element rootElement = doc.getRootElement();
		Element stuEle = rootElement.addElement("student").addAttribute("id", "o_362");
		stuEle.addElement("name").setText("王五");
		stuEle.addElement("age").setText("30");

		//	美观格式 
		// 设置编码
		OutputFormat format = OutputFormat.createPrettyPrint();
		OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream("src/com/ziv/xml/myxml.xml"), "UTF-8");
		XMLWriter xmlWriter = new XMLWriter(wr,format);
		xmlWriter.write(doc);
		wr.close();	//	关闭
	}

	public static void select() throws Exception {
		// 1.创建SAXReader
		SAXReader reader = new SAXReader();
		Document doc = reader.read("src/com/ziv/xml/myxml.xml");
		// 2.获取根元素
		Element rootElement = doc.getRootElement();
		// 3.获取根元素下的所有标签
		List<Element> elements = rootElement.elements("student");
		for (Element element : elements) {
			// 1) 获取方法一
			// Element eleName = element.element("name");
			// System.out.println(eleName.getText());

			// 2) 获取方法二
			String strName = element.elementText("name");
			String strAge = element.elementText("age");
			System.out.println(strName);
			System.out.println(strAge);

			// 3) 获取属性
			Attribute attrName = element.element("name").attribute("id");
			System.out.println(attrName);
		}
	}
}