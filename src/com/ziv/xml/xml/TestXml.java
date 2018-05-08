package com.ziv.xml.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月9日   下午3:06:01 
 * 类说明 :
 * 		xml 文档的解析
*/
public class TestXml {
	/**
	 * document,element,attr,text
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//	1.创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//	2.得到解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		//	3.获取节点对象
		Document doc = db.parse("src/com/ziv/xml/myxml.xml");
		
		addAttr(doc);
	}
	
	public static void addAttr(Document doc) throws Exception {
		Node attr = doc.getElementsByTagName("student").item(0);
		Element ele = (Element) attr;
		ele.setAttribute("class", "lj");
		//		从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/ziv/xml/myxml.xml"));
	}
	
	public static void remove(Document doc) throws Exception {
		NodeList nodeList = doc.getElementsByTagName("idcard");
		nodeList.item(0).getParentNode().removeChild(nodeList.item(0));
		//		从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/ziv/xml/myxml.xml"));
	}
	
	public static void add(Document doc) throws Exception {
		NodeList nodeList = doc.getElementsByTagName("student");
		Element ele = doc.createElement("idcard");
		ele.setTextContent("511322xxxxx");
		nodeList.item(0).appendChild(ele);
		//		从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/ziv/xml/myxml.xml"));
	}
	
	public static void update(Document doc) throws Exception {
		NodeList nodeList = doc.getElementsByTagName("name");
		nodeList.item(0).setTextContent("八重齿");
		//	从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/ziv/xml/myxml.xml"));
	}
	
	public static void select(Document doc) {
		
//		DocumentType documentType = doc.getDoctype();
//		System.out.println(documentType);
		
		//	这是一种便捷属性，该属性允许直接访问文档的文档元素的子节点。 
//		Element ele = doc.getDocumentElement();
//		String name = ele.getAttribute("students");
//		System.out.println(name);
		
		//	返回具有带给定值的 ID 属性的 Element。
//		Element ele = doc.getElementById("id");
//		System.out.println(ele);
		
		//	按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList。
		NodeList nodeList = doc.getElementsByTagName("name");
		System.out.println(nodeList.item(0).getTextContent());
	}
	
}