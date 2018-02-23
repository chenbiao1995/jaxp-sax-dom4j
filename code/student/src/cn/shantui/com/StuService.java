package cn.shantui.com;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.shantui.vo.Student;

public class StuService {

	//����
	public static void addStu(Student student) throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3����ȡ�����ڵ�
		 * 4���ڸ��ڵ������stu��ǩ
		 * 5����stu��ǩ���������id name age
		 * 6����id name age �����������ֵ
		 * 7����дxml
		 * */
		
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/student.xml");
		//�õ����ڵ�
		Element root = document.getRootElement();
		//�ڸ��ڵ��������stu
		Element stu = root.addElement("stu");
		//��stu��ǩ�����������id name age
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age1 = stu.addElement("age");
		//��id name age�����������ֵ
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		//��дxml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	//ɾ������ѧ����idɾ��
	public static void delStu(String id) throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3����ȡ�����е�id
		 * 		--xpath //id  ����list����
		 * 4������list����
		 * 5���жϼ������id�ʹ��ݵ�id�Ƿ���ͬ
		 * 6�������ͬ��id���ڵ�stuɾ��
		 * */
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/student.xml");
		//��ȡ���е�id
		List<Node> list = document.selectNodes("//id");
		//����list
		for (Node node : list) {
			//�õ�node��ÿһ��idԪ��
			//�õ�id��ֵ
			String idv = node.getText();
			//�ж�idv�ʹ��ݵ�id�Ƿ���ͬ
			if (idv.equals(id)) {
				//�õ�stu�Ľڵ�
				Element stu = node.getParent();
				//�õ�stu�ĸ��ڵ�
				Element student = stu.getParent();
				//ɾ��stu
				student.remove(stu);
			}
		}
		//��дxml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	//����id��ѯѧ����Ϣ
	public static Student getStu(String id) throws Exception {
		/*
		 * 1������������
		 * 2���õ�document
		 * 3����ȡ�����е�id
		 * 		--xpath //id  ����list����
		 * 4������list����
		 * 5���õ�ÿһ��id�Ľڵ�
		 * 6���õ�id�ڵ��ֵ
		 * 7���ж�id��ֵ�ʹ���id��ֵ�Ƿ���ͬ
		 * 8�������ͬ���Ȼ�ȡ��id�ĸ��ڵ�stu
		 * 9�����ݸ��ڵ��ȡname ageֵ
		 * */
		//����������
		SAXReader saxReader = new SAXReader();
		//�õ�document
		Document document = saxReader.read("src/student.xml");
		//��ȡ���е�id
		List<Node> list = document.selectNodes("//id");
		//����student����
		Student student = new Student();
		//����list
		for ( Node node : list) {
			//node��ÿһ��id�ڵ�
			//�õ�id�ڵ��ֵ
			String idv = node.getText();
			//�ж�id�Ƿ���ͬ
			if (idv.equals(id)) {
				//�õ�id�ĸ��ڵ�stu
				Element stu = node.getParent();
				//ͨ��stu��ȡname ��age
				String namev = stu.element("name").getText();
				String agev = stu.element("age").getText();
				student.setId(idv);
				student.setName(namev);
				student.setAge(agev);
			}
		}
		return student;
	}
}
