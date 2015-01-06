package ivyy.taobao.com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *@Author:liangjilong
 *@Date:2013-8-8
 *@Email:jilongliang@sina.com
 *@Version:Version1.0
 *@CopyRight:liangjilong
 *@Description:
 */
public class JsoupStr {
	
	public static void main(String[] args) {
		
		 StringBuffer buffer=new StringBuffer("<table border=\"1\" align=\"center\">");
		 buffer.append("<tr><td colspan=\"2\" class='td'>名&nbsp;&nbsp;称:</td><td id=\"name\"></td></tr>");
		 buffer.append("<tr><td colspan=\"2\" class='td'>地&nbsp;&nbsp;址:</td><td id=\"address\"></td></tr>");
		 buffer.append("<tr><td colspan=\"2\" class='td'><img src=\"images/1.png\"/></td></tr>");
		 buffer.append("</table>");
  		 String html=buffer.toString();
  		
  		
  		 Document doc=Jsoup.parse(html, "GBK");
  		 Elements table=doc.select("table");//选择table标签
  		 for(Element tab:table){
  			tab.attr("border", "2");//修改html网页的table的边框属性
  		 }
  		 Element td_classfirst = doc.select("td.td").first(); 
  		 //把第一个td的class=td的样式的标签都移除
  		 td_classfirst.remove();
  		 
  		 Element td_classlast = doc.select("td.td").last(); 
  		 //把第最后的一个td的class=td的样式的标签都移除
  		 td_classlast.remove();
  		 
  		 Elements pngs = doc.select("img[src$=.png]");// 所有引用 png 图片的元素
  		 for(Element png:pngs){
  			 String pngText=png.text();
  			 String src=png.attr("src");//根据属性名获取src的路径
  			 System.out.println(src+pngText);
  		 }
  		 //在id为address的td标签里面添加一个value等于121212121的值 如:<td id="address" value="121212121"></td>
  		 doc.getElementById("address").val("广东省云浮市闻莺路东升布艺");//设置value的值
  		 doc.getElementById("address").html("广东省云浮市闻莺路东升布艺");//设置html的值
  		 //在id为name的td标签添加一个文本值 如:<td id="name">121212121</td>
  		 doc.getElementById("name").html("东升布艺");//
  		 
  		 String newHtml=doc.toString();
  		
  		System.out.println(newHtml);
	}
}
