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
	//��ѯxml������nameԪ�ص�ֵ
	public static void selectName() throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3���õ����ڵ�
		 * 4���õ�p1
		 * 5���õ�p1�����name
		 * 6���õ�name���ֵ
		 * */
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/p1.xml");
		//�õ����ڵ�
		Element root = document.getRootElement();
		//�õ�p1
		List<Element> list = root.elements("p1");
		//����list
		for (Element element : list) {
			//element��ÿһ��p1��Ԫ��
			//�õ�p1�����nameԪ��
			Element name1 = element.element("name");
			//�õ�name1�����ֵ
			String s = name1.getText();
			System.out.println(s);
		}
		
	}
	
	//��ȡ����һ��nameԪ�������ֵ
	public static void selectSin() throws DocumentException {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3���õ����ڵ�
		 * 4���õ���һ��p1��Ԫ��
		 * 5���õ�p1�����nameԪ��
		 * 6���õ�nameԪ�������ֵ
		 * */
		
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/p1.xml");
		//�õ����ڵ�
		Element element = document.getRootElement();
		//�õ���һ��p1
		Element p1 = element.element("p1");
		//�õ�p1�����nameԪ��
		Element name = p1.element("name");
		//�õ�nameԪ�������ֵ
		String s = name.getText();
		System.out.println(s);
	}
	
	//��ȡ���ڶ���nameԪ�������ֵ
	public static void selectSecond() throws DocumentException {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3���õ����ڵ�
		 * 4���õ�����p1
		 * 5�������õ��ڶ���p1
		 * 6���õ��ڶ���p1�����name
		 * 7���õ�name�����ֵ
		 * */
		
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/p1.xml");
		//�õ����ڵ�
		Element element = document.getRootElement();
		//�õ����е�p1
		List<Element> list = element.elements("p1");
		//�õ��ڶ���p1 list���ϵ��±��0��ʼ
		Element p2 = list.get(1);
		//�õ�p1�����name
		Element name = p2.element("name");
		//�õ�name�����ֵ
		String s2 = name.getText();
		System.out.println(s2);
	}
	
	//�ڵ�һ��p1��ǩĩβ���һ��Ԫ��<sex>Ů</sex>
	public static void addSex() throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3���õ����ڵ�
		 * 4����ȡ����һ��p1
		 * 5����p1���±����Ԫ��
		 * 6����������֮���Ԫ����������ı�
		 * 7����д
		 * */
		
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/p1.xml");
		//�õ����ڵ�
		Element element = document.getRootElement();
		//�õ���һ��p1Ԫ��
		Element p1 = element.element("p1");
		//��p1����ֱ�����Ԫ��
		Element sex1 = p1.addElement("sex");
		//��sexԪ����������ı�
		sex1.setText("Ů");
		//��дxml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	
	//�ڵ�һ��p1�����age��ǩ֮�����<school></school>
	public static void addAgeBefore() throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3���õ����ڵ�
		 * 4����ȡ����һ��p1
		 * 5����ȡp1���������Ԫ��
		 * 		--elements() ����list����
		 * 		--ʹ��list����ķ������ض�λ�����Ԫ��
		 * 		--add(int index, E element) 
		 * 			--��һ���������±�λ�á��ڶ���������Ҫ��ӵ�Ԫ��
		 * */
//		//����������
//		SAXReader saxReader = new SAXReader();
//		//�õ�document
//		Document document = saxReader.read("src/p1.xml");

		
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//�õ����ڵ�
		Element element = document.getRootElement();
		//�õ���һ��p1Ԫ��
		Element p1 = element.element("p1");
		//��ȡ��p1���������Ԫ��
		List<Element> list = p1.elements();
		//����Ԫ��
		Element school = DocumentHelper.createElement("school");
		//��school���洴���ı�
		school.setText("text");
		//���ض�λ�����
		list.add(1, school);
		
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
//		//��дxml
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/p1.xml"), format);
//		xmlWriter.write(document);
//		xmlWriter.close();
	}
	
	
	//�޸ĵ�һ��p1�����age��ֵΪ30
	public static void modifyAge() throws Exception {
		/*
		 * 1���õ�document
		 * 	1��1���õ����ڵ�
		 * 2���õ���һ��p1Ԫ��
		 * 3���õ���һ��p1�����age
		 * 4���޸�ֵ��30
		 * 5����дxml
		 * */
		//�õ�ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//�õ����ڵ�
		Element root = document.getRootElement();
		//�õ���һ��p1
		Element p1 = root.element("p1");
		//�õ�p1�����age
		Element age = p1.element("age");
		//�õ�age��ֵ
		age.setText("3333");
		//��дxml
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
	}
	
	
	//ɾ����һ��p1�����school��ǩ
	public static void delSchool() throws Exception {
		/*
		 * 1���õ�document
		 * 	1��1���õ����ڵ�
		 * 2���õ���һ��p1Ԫ��
		 * 3���õ���һ��p1�����school
		 * 4��ɾ����ʹ�ø��ڵ�p1��
		 * 5����дxml
		 * */
		//�õ�ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//�õ����ڵ�
		Element root = document.getRootElement();
		//�õ���һ��p1
		Element p1 = root.element("p1");
		//�õ���һ��p1�����school
		Element school = p1.element("school");
		//ɾ��school
		//ͨ�����ڵ�ɾ��
//		school.getParent();
		p1.remove(school);
		//��дxml
		Dom4JUtils.xmlWriters(Dom4JUtils.PATH, document);
	}
	
	//ʹ��dom4j��ȡ����
	public static void getValues() throws Exception {
		/*
		 * 1���õ�document
		 * 	1��1���õ����ڵ�
		 * 2���õ���һ��p1Ԫ��
		 * 3���õ���һ��Ԫ�ص�����ֵ
		 * */
		//�õ�ducument
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//�õ����ڵ�
		Element root = document.getRootElement();
		//�õ���һ��p1
		Element p1 = root.element("p1");
		//�õ���һ��p1���������ֵ
		String value = p1.attributeValue("id1");
		System.out.println(value);
	}
}
