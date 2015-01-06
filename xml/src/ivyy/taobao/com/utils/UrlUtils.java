package ivyy.taobao.com.utils;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class UrlUtils {
	/***
	 * 获取百度地图的url
	 * @param ak秘钥即你在百度申请的key调用访问地图的key
	 * @param location地方的经纬度
	 * @param format格式（json或者xml）
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
