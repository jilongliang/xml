package ivyy.taobao.com.dom4j;

import ivyy.taobao.com.utils.Dom4jUtils;
import ivyy.taobao.com.utils.IoUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @Date:2015-1-6
 * @Author:liangjilong
 * @Email:jilongliang@sina.com
 * @Version:1.0
 * @Description��
 */
@SuppressWarnings("all")
public class Dom4jTest1 {

	public static void main(String[] args) {
		String fromRead = Dom4jTest1.class.getClassLoader().getResource("xml/class.xml").getPath();
		try {
			Document doc = getDocument(fromRead);
			// ��һ���ڵ�
			readOneElement(doc);
			// ����һ���ڵ�
			createElement(doc);
			// ���ڵ�д��
			createDocument(doc,"D:/test/new_class.xml");
			writerNode(doc);
			// ɾ��
			removeElement(doc);
		} catch (Exception e) {
		}
	}

	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Document getDocument(String path) throws Exception {
		// �õ�xml�ļ�
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new File(path));
		return doc;
	}

	/**
	 * �xȡһ�����c
	 * @param doc
	 */
	public static void readOneElement(Document doc) {
		// �õ�һ�����ڵ�
		Element root = doc.getRootElement();
		// �õ����ڵ��һ���ӽڵ�ļ���
		List list = root.elements("student");
		// �õ��ӽڵ㼯�ϵĵ�һ���ڵ�
		Element e = (Element) list.get(0);
		// ����ýڵ���ӽڵ���ı�����
		System.out.println(e.element("classId").getText());
	}

	/***
	 * ����һ�����cԪ��
	 * @param doc
	 */
	public static void createElement(Document doc) {

		Element root = doc.getRootElement();
		Element e = root.addElement("student");
		// �������
		e.addAttribute("userName", "노��|����ˇ");
		// �������
		e.setText("노��|����ˇ");
	}

	/**
	 * �Ƴ�һ�����cԪ��
	 * @param doc
	 */
	public static void removeElement(Document doc) {
		Element root = doc.getRootElement();
		// �õ����ڵ�student�ļ���
		List list = root.elements("student");
		// ȡ������student
		Element e = (Element) list.get(2);
		e.getParent().remove(e);
	}
	
	/***
	 * ����һ��xml�ęn
	 * @param doc
	 * @throws Exception
	 */
	public static void createDocument(Document doc,String toPath) throws Exception {
		File f=new File(toPath);
		if(!f.exists()){
			f.createNewFile();
		}
		IoUtils.write(doc.asXML(),toPath);
		Dom4jUtils.formatAsXml(doc);//��ʽxml
	}

	/***
	 * �����c
	 * @param doc
	 */
	public static void writerNode(Document doc) {
		// �õ��ڵ�
		Node e = doc.selectSingleNode("/class/student[1]/classId");//�@ȡ��һ��student���c��classIdֵ
		// ����ڵ�����
		System.out.println(e.getText());
		// ����ڵ����Ե�����
		e = doc.selectSingleNode("/class/student[1]/@userName");//�@ȡ��һ��student���c��userNameֵ
		System.out.println(e.getText());
	}

}