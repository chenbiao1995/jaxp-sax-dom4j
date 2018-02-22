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
		 * 1����������������
		 * 2������������
		 * 3��ִ��parse����
		 * 4���Լ�����һ���࣬�̳�DefaultHandler
		 * 5����д���������������
		 * */
		//��������������
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		//����������
		SAXParser saxParser = saxParserFactory.newSAXParser();
		//ִ��parser����
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

//��ȡ����nameԪ�ص�ֵ
class MyDefault2 extends DefaultHandler {
	
	boolean flag = false;
	int idx = 1;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//�ж�qName�Ƿ���nameԪ��
		//������1
		if("name".equals(qName)) {
			flag = true;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//��flagֵ��trueʱ���ʶ������nameԪ��
		if (flag == true && idx == 2) {
			System.out.println(new String(ch,start,length));
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//��flag���ó�false��ʶnameԪ�ؽ���
		if ("name".equals(qName)) {
			flag =false;
			idx = idx + 1;
		}
	}	
}
