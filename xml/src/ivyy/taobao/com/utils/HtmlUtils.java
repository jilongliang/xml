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
	 * ��ȡ���µ�����
	 * �����˵���ҳ������ͨ������body��id�Ϳ����õ���Ӧ����������..
	 * @param url
	 * @return
	 */
	public static String getNewsContent(String url) throws Exception{
		Document doc=Jsoup.parse(new URL(url), 3000);
		if(doc!=null){
			String artibody=doc.getElementById("artibody").html();//ͨ����ҳ��html��idȥ�õ���������artibody
			return artibody;
		}else{
			return "�����쳣";
		}
	}
}
