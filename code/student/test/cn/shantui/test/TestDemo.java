package cn.shantui.test;

import org.junit.jupiter.api.Test;
//使用junit  测试类不能叫Test
public class TestDemo {
	
	@Test
	public void testAdd() {
		TestStu testStu = new TestStu();
		testStu.add(2, 3);
	}
}
