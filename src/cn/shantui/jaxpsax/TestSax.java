package cn.shantui.jaxpsax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSax {

	public static void main(String[] args) throws Exception {
		
		/*
		 * 1、创建解析器工厂
		 * 2、创建解析器
		 * 3、执行parse方法
		 * 4、自己创建一个类，继承DefaultHandler
		 * 5、重写类里面的三个方法
		 * */
		//创建解析器工厂
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		//创建解析器
		SAXParser saxParser = saxParserFactory.newSAXParser();
		//执行parser方法
		saxParser.parse("src/p1.xml",new MyDefault2());
	}

}

class MyDefault1 extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.print("<"+qName+">");
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		System.out.print(new String(ch,start,length));
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		System.out.print("</"+qName+">");
	}	
}

//获取所有name元素的值
class MyDefault2 extends DefaultHandler {
	
	boolean flag = false;
	int idx = 1;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//判断qName是否是name元素
		//索引是1
		if("name".equals(qName)) {
			flag = true;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//当flag值是true时候标识解析到name元素
		if (flag == true && idx == 2) {
			System.out.println(new String(ch,start,length));
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//把flag设置成false标识name元素结束
		if ("name".equals(qName)) {
			flag =false;
			idx = idx + 1;
		}
	}	
}
