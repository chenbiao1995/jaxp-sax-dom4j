package cn.shantui.test;

import cn.shantui.com.StuService;
import cn.shantui.vo.Student;

public class TestStu {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
		testSelect();
	}
	//������ӷ���
	public static void testAdd() throws Exception {
		//����ֵ
		Student stu = new Student();
		stu.setId("103");
		stu.setName("��");
		stu.setAge("23");
		
		StuService.addStu(stu);
		
	}
	//����ɾ���ķ���
	public static void testDelete() throws Exception {
		StuService.delStu("103");
	}
	//���Բ�ѯ����
	public static void testSelect() throws Exception {
		Student stu = StuService.getStu("100");
		System.out.println(stu);
	}
	public static void add(int a,int b) {
		System.out.println(a+b);
	}
}
