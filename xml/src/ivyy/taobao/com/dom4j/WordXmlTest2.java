package ivyy.taobao.com.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
@SuppressWarnings("all")
public class WordXmlTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String fromRead=WordXmlTest1.class.getClassLoader().getResource("xml/office_word.xml").getPath();
		
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File(fromRead));
			Element rootEl = document.getRootElement();
			p("根节点:\t\t" + rootEl.getName());

			for (Iterator iter = rootEl.elementIterator(); iter.hasNext();) {
				Element el = (Element) iter.next();

				p("Class:\t\t" + el.getName());
				/**
				 * attribute是循环出来的元素
				 */
				for (Iterator it = el.attributeIterator(); it.hasNext();) {
					Attribute attribute = (Attribute) it.next();
					p("ClassName:\t" + attribute.getName() + "--"
							+ attribute.getValue());
				}
			}
			List<Node> listNode = document.selectNodes("//w:body/w:r/w:instrText");
			for (Node n : listNode) {
				System.out.println("Property:\t\t" + n.getName());
				p("Name:\t\t" + n.valueOf("w:val"));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param obj
	 */
	public static void p(Object obj) {
		System.out.println(obj);
	}

}

