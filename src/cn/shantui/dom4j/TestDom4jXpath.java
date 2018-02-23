package cn.shantui.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import cn.shantui.utils.Dom4JUtils;

/**	
	//使用xpath实现：查询xml中所有name元素的值
		name :所有name元素
		selectNodes("//name")
 * @author lenovo
 *
 */
public class TestDom4jXpath {
	public static void main(String[] args) throws Exception {
//		test1();
		test2();
	}
	
	//查询xml中所有name元素的值
	public static void test1() throws Exception {
		/*
		 * 1、得到document
		 * 2、直接使用selectNodes("//name")方法得到所有name元素
		 * */
		//1
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//2
		List<Node> list = document.selectNodes("//name");
		//遍历list集合
		for (Node node : list) {
			//node是每一个name元素
			//得到name元素里面的值
			String s = node.getText();
			System.out.println(s);
		}
	}
	//使用xpath实现：获取第一个p1下面的name的值
	public static void test2() throws Exception {
		/*
		 * 1、得到document
		 * 2、直接使用selectNodes("//name")方法得到所有name元素
		 * */
		//1
		Document document = Dom4JUtils.getDocument(Dom4JUtils.PATH);
		//2
		Node name1 = document.selectSingleNode("//p1[@id1='aaa']/name");
		//得到name里面的值
		String text = name1.getText();
		System.out.println(text);
	}
}
