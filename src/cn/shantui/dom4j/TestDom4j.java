package cn.shantui.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.DocumentHandler;

import cn.shantui.utils.Dom4JUtils;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
//		selectName();
//		selectSin();
//		selectSecond();
//		addSex();
//		addAgeBefore();
//		modifyAge();
//		delSchool();
		getValues();
	}
	//查询xml中所有name元素的值
	public static void selectName() throws Exception {
		/*
		 * 1、创建解析器
		 * 2、得到document
		 * 3、得到根节点
		 * 4、得到p1
		 * 5、得到p1下面的name
		 * 6、得到name里的值
		 * */
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element root = document.getRootElement();
		//得到p1
		List<Element> list = root.elements("p1");
		//遍历list
		for (Element element : list) {
			//element是每一个p1的元素
			//得到p1下面的name元素
			Element name1 = element.element("name");
			//得到name1里面的值
			String s = name1.getText();
			System.out.println(s);
		}
		
	}
	
	//获取到第一个name元素里面的值
	public static void selectSin() throws DocumentException {
		/*
		 * 1、创建解析器
		 * 2、得到document
		 * 3、得到根节点
		 * 4、得到第一个p1的元素
		 * 5、得到p1下面的name元素
		 * 6、得到name元素里面的值
		 * */
		
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element element = document.getRootElement();
		//得到第一个p1
		Element p1 = element.element("p1");
		//得到p1下面的name元素
		Element name = p1.element("name");
		//得到name元素里面的值
		String s = name.getText();
		System.out.println(s);
	}
	
	//获取到第二个name元素里面的值
	public static void selectSecond() throws DocumentException {
		/*
		 * 1、创建解析器
		 * 2、得到document
		 * 3、得到根节点
		 * 4、得到所有p1
		 * 5、遍历得到第二个p1
		 * 6、得到第二个p1下面的name
		 * 7、得到name下面的值
		 * */
		
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element element = document.getRootElement();
		//得到所有的p1
		List<Element> list = element.elements("p1");
		//得到第二个p1 list集合的下标从0开始
		Element p2 = list.get(1);
		//得到p1下面的name
		Element name = p2.element("name");
		//得到name里面的值
		String s2 = name.getText();
		System.out.println(s2);
	}
	
	//在第一个p1标签末尾添加一个元素<sex>女</sex>
	public static void addSex() throws Exception {
		/*
		 * 1、创建解析器
		 * 2、得到document
		 * 3、得到根节点
		 * 4、获取到第一个p1
		 * 5、在p1的下边添加元素
		 * 6、在添加完成之后的元素下面添加文本
		 * 7、回写
		 * */
		
		//创建解析器
		SAXReader saxReader = new SAXReader();
		//得到document
		Document document = saxReader.read("src/p1.xml");
		//得到根节点
		Element element = document.getRootElement();
		//得到第一个p1元素
		Element p1 = element.element("p1");
		//在p1下面直接添加元素
		Element sex1 = p1.addElement("sex");
		//在sex元素下面添加文本
		sex1.setText("女");
		//回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	
	//在第一个p1下面的age标签之间添加<school></school>
	public static void addAgeBefore() throws Exception {
		/*
		 * 1、创建解析器
		 * 2、得到document
		 * 3、得到根节点
		 * 4、获取到第一个p1
		 * 5、获取p1下面的所有元素
		 * 		--elements() 返回list集合
		 * 		--使用list里面的方法在特定位置添加元素
		 * 		--add(int index, E element) 
		 * 			--第一个参数：下标位置。第二个参数：要添加的元素
		 * */
//		//创建解析器
//		SAXReader saxReader = new SAXReader();
//		//得到document
//		Document document = saxReader.read("src/p1.xml");

		
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//得到根节点
		Element element = document.getRootElement();
		//得到第一个p1元素
		Element p1 = element.element("p1");
		//获取到p1下面的所有元素
		List<Element> list = p1.elements();
		//创建元素
		Element school = DocumentHelper.createElement("school");
		//在school下面创建文本
		school.setText("text");
		//在特定位置添加
		list.add(1, school);
		
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
//		//回写xml
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
//		xmlWriter.write(document);
//		xmlWriter.close();
	}
	
	
	//修改第一个p1下面的age的值为30
	public static void modifyAge() throws Exception {
		/*
		 * 1、得到document
		 * 	1。1、得到根节点
		 * 2、得到第一个p1元素
		 * 3、得到第一个p1下面的age
		 * 4、修改值是30
		 * 5、回写xml
		 * */
		//得到ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//得到根节点
		Element root = document.getRootElement();
		//得到第一个p1
		Element p1 = root.element("p1");
		//得到p1下面的age
		Element age = p1.element("age");
		//得到age的值
		age.setText("3333");
		//回写xml
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
	}
	
	
	//删除第一个p1下面的school标签
	public static void delSchool() throws Exception {
		/*
		 * 1、得到document
		 * 	1。1、得到根节点
		 * 2、得到第一个p1元素
		 * 3、得到第一个p1下面的school
		 * 4、删除（使用父节点p1）
		 * 5、回写xml
		 * */
		//得到ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//得到根节点
		Element root = document.getRootElement();
		//得到第一个p1
		Element p1 = root.element("p1");
		//得到第一个p1下面的school
		Element school = p1.element("school");
		//删除school
		//通过父节点删除
//		school.getParent();
		p1.remove(school);
		//回写xml
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
	}
	
	//使用dom4j获取属性
	public static void getValues() throws Exception {
		/*
		 * 1、得到document
		 * 	1。1、得到根节点
		 * 2、得到第一个p1元素
		 * 3、得到第一个元素的属性值
		 * */
		//得到ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//得到根节点
		Element root = document.getRootElement();
		//得到第一个p1
		Element p1 = root.element("p1");
		//得到第一个p1里面的属性值
		String value = p1.attributeValue("id1");
		System.out.println(value);
	}
}
