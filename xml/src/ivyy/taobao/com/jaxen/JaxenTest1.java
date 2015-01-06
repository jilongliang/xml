package ivyy.taobao.com.jaxen;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jaxen.Navigator;
import org.jaxen.XPath;
import org.jaxen.function.StringFunction;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class JaxenTest1 {
	public static void main(String[] args)throws Exception{
		String filePath = JaxenTest1.class.getClassLoader().getResource("xml/about.xml").getPath();
		InputStream in=new FileInputStream(new File(filePath));
		readResponse(in);

	}
	
	 public static void readResponse(InputStream in)throws Exception {

		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    factory.setNamespaceAware(true);   
		    DocumentBuilder builder = factory.newDocumentBuilder();    
		    
		    InputSource data = new InputSource(in);
		    Node doc = (Node) builder.parse(data);
		    
		    System.out.println(doc);
		    // There are different XPath classes in different packages
		    // for the different APIs Jaxen supports
		    XPath expression = new org.jaxen.dom.DOMXPath("/SOAP:Envelope/SOAP:Body/f:Fibonacci_Numbers/f:fibonacci");
		    expression.addNamespace("f", "http://namespaces.cafeconleche.org/xmljava/ch3/");
		    expression.addNamespace("SOAP", "http://schemas.xmlsoap.org/soap/envelope/");
		    Navigator navigator = expression.getNavigator();

		    List results = expression.selectNodes(doc);
		    Iterator iterator = results.iterator();
		    while (iterator.hasNext()) {
			      Node result = (Node) iterator.next();
			      String value = StringFunction.evaluate(result, navigator);
			      System.out.println(value);
		    }

	 }
}
