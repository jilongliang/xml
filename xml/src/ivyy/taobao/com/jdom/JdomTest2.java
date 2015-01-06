package ivyy.taobao.com.jdom;

import java.io.File;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：解析本地的xml
 */
public class JdomTest2 {

	public static void main(String[] args) throws Exception{ 
		
		String filePath=JdomTest2.class.getClassLoader().getResource("xml/about.xml").getPath();
		SAXBuilder sb=new SAXBuilder();
	    Document doc=sb.build(new File(filePath));
	    
	    Element  rootEl= doc.getRootElement();//获取root节点
	    //Element resultEl=rootEl.getChild("result");//获取result节点
	    
	    //获得所有子节点元素
        List<Element> list = rootEl.getChildren();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String weibo=element.getChildText("weibo");
			String weixinGonggongHao=element.getChildText("weixinGonggongHao");
			String email=element.getChildText("email");
			String dsname=element.getChildText("dsname");
			String taobao=element.getChildText("taobao");
			
			String name=element.getName();//获取节点的name
			String weiboId=element.getChild("weibo").getAttributeValue("id");//获取weibo节点的id
			URI uri=element.getXMLBaseURI();//获取当前xml文件的路径
			
			//System.out.println(weixinGonggongHao);
		}
	    
	}
}





