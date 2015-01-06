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
 *@Description：使用jdom2组装一个xml文件，并且格式化
 */
public class JdomTest1 {

	public static void main(String[] args) throws Exception{
	 
		// 创建一个result的元素
		Element resultEl = new Element("result");
		// 创建vin属性，并设置值
		resultEl.setAttribute("weibo", "http://weibo.com/resourceljl");
		// 创建注释
		resultEl.addContent(new Comment("this a result Node!"));
		// 创建一个weixinGonggongHao元素，设置文本内容
		resultEl.addContent(new Element("weixinGonggongHao").setText("liangjilong88"));
		// 创建一个email元素，添加一个文本元素
		resultEl.addContent(new Element("email").setContent(new Text("1302128216@qq.com")));

		// 创建一个name元素，添加文本内容
		resultEl.addContent(new Element("name").addContent("云浮东升布艺"));

		// 创建一个userInfoEl的元素
		Element userInfoEl = new Element("userInfo");
		// 为userInfo元素添加文本内容
		userInfoEl.addContent("QQ:1302128216");
		// 创建一个qq的属性，值为1302128216
		userInfoEl.setAttribute("qq", "1302128216");
		// 将userInfoEl添加到根元素中
		resultEl.addContent(userInfoEl);
		// 将result元素设置为根元素
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





