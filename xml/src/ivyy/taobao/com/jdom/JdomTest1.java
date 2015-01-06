package ivyy.taobao.com.jdom;

import ivyy.taobao.com.utils.JdomUtils;

import java.io.File;

import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description��ʹ��jdom2��װһ��xml�ļ������Ҹ�ʽ��
 */
public class JdomTest1 {

	public static void main(String[] args) throws Exception{
	 
		// ����һ��result��Ԫ��
		Element resultEl = new Element("result");
		// ����vin���ԣ�������ֵ
		resultEl.setAttribute("weibo", "http://weibo.com/resourceljl");
		// ����ע��
		resultEl.addContent(new Comment("this a result Node!"));
		// ����һ��weixinGonggongHaoԪ�أ������ı�����
		resultEl.addContent(new Element("weixinGonggongHao").setText("liangjilong88"));
		// ����һ��emailԪ�أ����һ���ı�Ԫ��
		resultEl.addContent(new Element("email").setContent(new Text("1302128216@qq.com")));

		// ����һ��nameԪ�أ�����ı�����
		resultEl.addContent(new Element("name").addContent("�Ƹ���������"));

		// ����һ��userInfoEl��Ԫ��
		Element userInfoEl = new Element("userInfo");
		// ΪuserInfoԪ������ı�����
		userInfoEl.addContent("QQ:1302128216");
		// ����һ��qq�����ԣ�ֵΪ1302128216
		userInfoEl.setAttribute("qq", "1302128216");
		// ��userInfoEl��ӵ���Ԫ����
		resultEl.addContent(userInfoEl);
		// ��resultԪ������Ϊ��Ԫ��
		Document doc = new Document(resultEl);
		JdomUtils.print(doc);
		
		
		String filePath="D:/test/jdom.xml";
		File f=new File(filePath);
		if(!f.exists()){
			f.createNewFile();
		}
		JdomUtils.formatAsXML(doc, filePath);
	}
}





