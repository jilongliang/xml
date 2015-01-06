package ivyy.taobao.com.jsoup;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description£º
 */
public class JsoupDbHelper {
	
	public static void main(String[] args)throws Exception {
		String filePath=JsoupDbHelper.class.getClassLoader().getResource("xml/jdbc-config.xml").getPath();
		
		Document doc=Jsoup.parse(new File(filePath), "utf-8");
		String driver=doc.select("driver-name").text();
		String url=doc.select("url").text();
		String username=doc.select("username").text();
		String password=doc.select("password").text();
		
		System.out.println(password);
		
	}
}
