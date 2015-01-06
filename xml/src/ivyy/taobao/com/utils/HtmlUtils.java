package ivyy.taobao.com.utils;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *@Author:liangjilong
 *@Date:2014-1-7
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Descript: 
 */
public class HtmlUtils {
	/***
	 * 获取文章的内容
	 * 从新浪的网页分析，通过文章body的id就可以拿到相应的文章内容..
	 * @param url
	 * @return
	 */
	public static String getNewsContent(String url) throws Exception{
		Document doc=Jsoup.parse(new URL(url), 3000);
		if(doc!=null){
			String artibody=doc.getElementById("artibody").html();//通过网页的html的id去拿到新闻内容artibody
			return artibody;
		}else{
			return "网络异常";
		}
	}
}
