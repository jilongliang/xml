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
 * @Description：
 */
@SuppressWarnings("all")
public class Dom4jTest1 {

	public static void main(String[] args) {
		String fromRead = Dom4jTest1.class.getClassLoader().getResource("xml/class.xml").getPath();
		try {
			Document doc = getDocument(fromRead);
			// 读一个节点
			readOneElement(doc);
			// 创建一个节点
			createElement(doc);
			// 将节点写入
			createDocument(doc,"D:/test/new_class.xml");
			writerNode(doc);
			// 删除
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
		// 得到xml文件
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new File(path));
		return doc;
	}

	/**
	 * 讀取一個節點
	 * @param doc
	 */
	public static void readOneElement(Document doc) {
		// 得到一个根节点
		Element root = doc.getRootElement();
		// 得到根节点的一个子节点的集合
		List list = root.elements("student");
		// 得到子节点集合的第一个节点
		Element e = (Element) list.get(0);
		// 输出该节点的子节点的文本内容
		System.out.println(e.element("classId").getText());
	}

	/***
	 * 創建一個節點元素
	 * @param doc
	 */
	public static void createElement(Document doc) {

		Element root = doc.getRootElement();
		Element e = root.addElement("student");
		// 添加属性
		e.addAttribute("userName", "雲浮東升布藝");
		// 添加内容
		e.setText("雲浮東升布藝");
	}

	/**
	 * 移除一個節點元素
	 * @param doc
	 */
	public static void removeElement(Document doc) {
		Element root = doc.getRootElement();
		// 得到根节点student的集合
		List list = root.elements("student");
		// 取第三个student
		Element e = (Element) list.get(2);
		e.getParent().remove(e);
	}
	
	/***
	 * 創建一個xml文檔
	 * @param doc
	 * @throws Exception
	 */
	public static void createDocument(Document doc,String toPath) throws Exception {
		File f=new File(toPath);
		if(!f.exists()){
			f.createNewFile();
		}
		IoUtils.write(doc.asXML(),toPath);
		Dom4jUtils.formatAsXml(doc);//格式xml
	}

	/***
	 * 寫節點
	 * @param doc
	 */
	public static void writerNode(Document doc) {
		// 得到节点
		Node e = doc.selectSingleNode("/class/student[1]/classId");//獲取第一個student節點的classId值
		// 输出节点内容
		System.out.println(e.getText());
		// 输出节点属性的内容
		e = doc.selectSingleNode("/class/student[1]/@userName");//獲取第一個student節點的userName值
		System.out.println(e.getText());
	}

}