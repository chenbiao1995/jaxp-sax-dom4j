package cn.shantui.test;

import org.junit.jupiter.api.Test;
//ʹ��junit  �����಻�ܽ�Test
public class TestDemo {
	
	@Test
	public void testAdd() {
		TestStu testStu = new TestStu();
		testStu.add(2, 3);
	}
}
