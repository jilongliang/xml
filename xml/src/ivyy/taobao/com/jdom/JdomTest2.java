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
 *@Description���������ص�xml
 */
public class JdomTest2 {

	public static void main(String[] args) throws Exception{ 
		
		String filePath=JdomTest2.class.getClassLoader().getResource("xml/about.xml").getPath();
		SAXBuilder sb=new SAXBuilder();
	    Document doc=sb.build(new File(filePath));
	    
	    Element  rootEl= doc.getRootElement();//��ȡroot�ڵ�
	    //Element resultEl=rootEl.getChild("result");//��ȡresult�ڵ�
	    
	    //��������ӽڵ�Ԫ��
        List<Element> list = rootEl.getChildren();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String weibo=element.getChildText("weibo");
			String weixinGonggongHao=element.getChildText("weixinGonggongHao");
			String email=element.getChildText("email");
			String dsname=element.getChildText("dsname");
			String taobao=element.getChildText("taobao");
			
			String name=element.getName();//��ȡ�ڵ��name
			String weiboId=element.getChild("weibo").getAttributeValue("id");//��ȡweibo�ڵ��id
			URI uri=element.getXMLBaseURI();//��ȡ��ǰxml�ļ���·��
			
			//System.out.println(weixinGonggongHao);
		}
	    
	}
}





