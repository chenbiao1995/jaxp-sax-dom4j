package cn.itcast.test03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**泛型在集合上的使用
 * @author lenovo
 *
 */
public class TestDemo2 {
	//泛型在list上的使用
	@Test
	public void testList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		//遍历list集合
		//三种方式 普通for 增强for 迭代器
		//普通for
		for (int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//增强for
		for (String string : list) {
			
			System.out.println(string);
		}
		//迭代器
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	//泛型使用在set集合上
	@Test
	public void testSet() {
		Set<String> set = new HashSet<String>();
		set.add("qqq");
		set.add("www");
		//遍历set
		//两种  迭代器   增强for
		for (String s2 : set) {
			System.out.println(s2);
		}
		Iterator<String> it1 = set.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
	//在map上面使用泛型
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String,String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		//遍历map 两种方式
		//1、获取所有的key 通过key得到value  使用get方法
		//2、获取key和value的关系
		//使用第一种方式遍历
		//获取所有的key
		Set<String> sets = map.keySet();
		//遍历所有key返回set
		for (String key : sets) {
			//通过key得到value
			String value = map.get(key);
			System.out.println(key+""+value);
			
		}
		System.out.println("===============");
		//第二种方式
		//得到key和value的关系
		Set<Entry<String, String>> sets1 = map.entrySet();
		//遍历sets1
		for (Entry<String, String> entry : sets1) {
			//entry是key和value关系
			String keyv = entry.getKey();
			String valuev =entry.getValue();
			System.out.println(keyv+valuev);
		}
	}
	
}
