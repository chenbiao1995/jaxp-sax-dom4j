package cn.shantui.utils;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtils {
	public static final String PATH ="src/p1.xml";
	//����document
	public static Document getDocument(String path) {
		try {
		//����������
		SAXReader reader = new SAXReader();
		//�õ�document
		Document document = reader.read(path);
		return document;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//��дxml����
	public static void xmlWriters(String path,Document document) {
		try {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
		xmlWriter.write(document);
		xmlWriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
