package cn.shantui.test;

import cn.shantui.com.StuService;
import cn.shantui.vo.Student;

public class TestStu {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
		testSelect();
	}
	//测试添加方法
	public static void testAdd() throws Exception {
		//设置值
		Student stu = new Student();
		stu.setId("103");
		stu.setName("陈");
		stu.setAge("23");
		
		StuService.addStu(stu);
		
	}
	//测试删除的方法
	public static void testDelete() throws Exception {
		StuService.delStu("103");
	}
	//测试查询方法
	public static void testSelect() throws Exception {
		Student stu = StuService.getStu("100");
		System.out.println(stu);
	}
	public static void add(int a,int b) {
		System.out.println(a+b);
	}
}
