package ivyy.taobao.com.jdom;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filter;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.jaxen.JaxenXPathFactory;


/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：jdom的XPathBuilder、XPathFactory、XPathExpression使用
 */
public class JdomTest3 {

	public static void main(String[] args) throws Exception {
		String filePath = JdomTest3.class.getClassLoader().getResource("xml/about.xml").getPath();

		//getXmlTextByXPath1(filePath);
		getXmlTextByXPath2(filePath);
		
	}

	/****
	 * XPathBuilder、XPathFactory、XPathExpression使用
	 * @param filePath
	 * @throws JDOMException
	 * @throws IOException
	 */
	private static void getXmlTextByXPath1(String filePath) throws JDOMException, IOException {
		
		SAXBuilder builer = new SAXBuilder();
		Document doc = builer.build(new File(filePath));
		Element rootEl=doc.getRootElement();
		Filter<Element> filter = Filters.element();
		
		XPathBuilder<Element> xpBuilder=new XPathBuilder<Element>("/response/result", filter);
		XPathFactory factory=JaxenXPathFactory.instance();

		XPathExpression<Element> compileWith = xpBuilder.compileWith(factory);
		List<Element> result = compileWith.diagnose(rootEl, false).getResult();
		
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			System.out.println(element.getChildText("weibo"));
		}
	}
	
	/**
	 * XPathBuilder、XPathFactory、XPathExpression使用
	 * @param filePath
	 * @throws JDOMException
	 * @throws IOException
	 */
	private static void getXmlTextByXPath2(String filePath) throws JDOMException, IOException {
		SAXBuilder builer = new SAXBuilder();
		Document doc = builer.build(new File(filePath));
		Element rootEl=doc.getRootElement();
		XPathExpression<Element> xpBuilder = XPathFactory.instance().compile("/response/result", Filters.element());
		List<Element> result = xpBuilder.diagnose(rootEl, false).getResult();
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			System.out.println(element.getChildText("weibo"));
		}
	}
}





