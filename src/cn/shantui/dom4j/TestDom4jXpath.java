package cn.shantui.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import cn.shantui.utils.Dom4JUtils;

/**	
	//ʹ��xpathʵ�֣���ѯxml������nameԪ�ص�ֵ
		name :����nameԪ��
		selectNodes("//name")
 * @author lenovo
 *
 */
public class TestDom4jXpath {
	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}
	
	//��ѯxml������nameԪ�ص�ֵ
	public static void test1() throws Exception {
		/*
		 * 1���õ�document
		 * 2��ֱ��ʹ��selectNodes("//name")�����õ�����nameԪ��
		 * */
		//1
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//2
		List<Node> list = document.selectNodes("//name");
		//����list����
		for (Node node : list) {
			//node��ÿһ��nameԪ��
			//�õ�nameԪ�������ֵ
			String s = node.getText();
			System.out.println(s);
		}
	}
	//ʹ��xpathʵ�֣���ȡ��һ��p1�����name��ֵ
	public static void test2() throws Exception {
		/*
		 * 1���õ�document
		 * 2��ֱ��ʹ��selectNodes("//name")�����õ�����nameԪ��
		 * */
		//1
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//2
		Node name1 = document.selectSingleNode("//p1[@id1='aaa']/name");
		//�õ�name�����ֵ
		String text = name1.getText();
		System.out.println(text);
	}
}
