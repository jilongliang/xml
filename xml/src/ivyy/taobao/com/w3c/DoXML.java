package ivyy.taobao.com.w3c;


import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 * ====================================
 * @Author:jilongliang
 * @Email:jilongliang@sina.com
 * @Date:2015-1-5
 * @CopyRight:liangjilong
 * @Description:
 * ====================================
 * XMLInputFactory
 * XMLStreamReader
 * XMLEventReader解析XML文件
 * ====================================
 */
public class DoXML {
	private String url="config/xml/MyXml.xml";
	/**
	 * 文件读取流获取XML节点
	 * @throws IOException
	 */
	@Test
	public void testXMLStreamReader() throws IOException {
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			InputStream in = DoXML.class.getClassLoader().getResourceAsStream(url);
			XMLStreamReader reader = factory.createXMLStreamReader(in);
			while (reader.hasNext()) {
				int type = reader.next();
				if(type==XMLStreamConstants.START_ELEMENT){//开始节点
					System.out.print(reader.getName());
				}else if(type==XMLStreamConstants.CHARACTERS){//表示事件字符
					System.out.println("type"+type);
				}else if(type==XMLStreamConstants.END_ELEMENT){//结束节点
					System.out.println(reader.getName());
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * XML事件读取
	 */
	//@Test
	public void testXMLEventReader(){
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			InputStream in = DoXML.class.getClassLoader().getResourceAsStream(url);
			XMLEventReader reader = factory.createXMLEventReader(in);
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				if(event.isStartElement()){
					String name = event.asStartElement().getName().toString();
					if("Title".equals(name)){
						System.out.println(reader.getElementText());
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过XML事件Filter过滤节点的值
	 */
	//@Test
	public void testXMLFilteredReader(){
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			InputStream in = DoXML.class.getClassLoader().getResourceAsStream(url);
			XMLEventReader eventReader = factory.createXMLEventReader(in);
			XMLEventReader reader = factory.createFilteredReader(eventReader, new EventFilter() {
				@Override
				public boolean accept(XMLEvent event) {
					//有Titl节点返回true，否则返回false
					if(event.isStartElement()) {
						String name = event.asStartElement().getName().toString();
						if(name.equals("Title")){
							return true;
						}
					}
					return false;
				}
			});
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				if(event.isStartElement()){
					String name = event.asStartElement().getName().toString();
					if("Title".equals(name)){
						System.out.println(reader.getElementText());
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过XPath拿节点的值
	 */
	//@Test
	public void testXPathXMLNodeText(){
		try {
			InputStream in = DoXML.class.getClassLoader().getResourceAsStream(url);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder  db = factory.newDocumentBuilder();
			Document doc = db.parse(in);
			
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();
			String expression = "Articles//item[@category='language']";
			
			NodeList nodeList = (NodeList)xpath.evaluate(expression,doc,XPathConstants.NODESET);
			for(int i = 0 ; i< nodeList.getLength();i++){
				Element	 ele = (Element)(nodeList.item(i));
				NodeList tiel =   ele.getElementsByTagName("Title");
				Element e  = (Element) tiel.item(0);
				System.out.println(e.getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 修改XML节点的值
	 */
	//@Test
	public void testUpdateXMLNodeText(){
		try {
			InputStream in = DoXML.class.getClassLoader().getResourceAsStream(url);
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
			XPath xPath = XPathFactory.newInstance().newXPath();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			String expression = "Articles//item[@category='language']/Title";//修改Title的值
			NodeList nodelist = (NodeList)xPath.evaluate(expression, doc,XPathConstants.NODESET);
			Element price = (Element)(nodelist.item(0));
			price.setTextContent("PHP");
			transformer.transform(new DOMSource(doc), new StreamResult(System.out));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 组装XML
	 */
	//@Test
	public void testXMLStreamWriter(){
		/*
		try {
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = factory.createXMLStreamWriter(System.out);
			String ns= "http://weibo.com/resourceljl";
			writer.writeStartDocument("UTF-8","1.0");
			writer.setDefaultNamespace(ns);
			writer.writeDefaultNamespace(ns);
			writer.writeNamespace("ns", ns);
			writer.setPrefix("ns", ns);
			writer.writeStartElement("ns","this",ns);
			writer.writeCharacters("test");
			writer.writeStartElement("ns","test",ns);
			writer.writeCharacters("content");
			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
	}
}
