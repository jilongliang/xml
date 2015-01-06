package ivyy.taobao.com.utils;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description��
 */
public class UrlUtils {
	/***
	 * ��ȡ�ٶȵ�ͼ��url
	 * @param ak��Կ�����ڰٶ������key���÷��ʵ�ͼ��key
	 * @param location�ط��ľ�γ��
	 * @param format��ʽ��json����xml��
	 * @return
	 */
	public static String getBaiduMapUrl(String ak,String location,String format){
		StringBuffer buffer=new StringBuffer("http://api.map.baidu.com/geocoder/v2/?");
		String url="";
		buffer.append("ak="+ak);
		buffer.append("&callback=renderReverse");
		buffer.append("&location="+location);
		buffer.append("&output="+format);
		buffer.append("&pois=1");
		url=buffer.toString();
		return url;
	}
	
}
