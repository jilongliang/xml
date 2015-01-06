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
		 buffer.append("<tr><td colspan=\"2\" class='td'>��&nbsp;&nbsp;��:</td><td id=\"name\"></td></tr>");
		 buffer.append("<tr><td colspan=\"2\" class='td'>��&nbsp;&nbsp;ַ:</td><td id=\"address\"></td></tr>");
		 buffer.append("<tr><td colspan=\"2\" class='td'><img src=\"images/1.png\"/></td></tr>");
		 buffer.append("</table>");
  		 String html=buffer.toString();
  		
  		
  		 Document doc=Jsoup.parse(html, "GBK");
  		 Elements table=doc.select("table");//ѡ��table��ǩ
  		 for(Element tab:table){
  			tab.attr("border", "2");//�޸�html��ҳ��table�ı߿�����
  		 }
  		 Element td_classfirst = doc.select("td.td").first(); 
  		 //�ѵ�һ��td��class=td����ʽ�ı�ǩ���Ƴ�
  		 td_classfirst.remove();
  		 
  		 Element td_classlast = doc.select("td.td").last(); 
  		 //�ѵ�����һ��td��class=td����ʽ�ı�ǩ���Ƴ�
  		 td_classlast.remove();
  		 
  		 Elements pngs = doc.select("img[src$=.png]");// �������� png ͼƬ��Ԫ��
  		 for(Element png:pngs){
  			 String pngText=png.text();
  			 String src=png.attr("src");//������������ȡsrc��·��
  			 System.out.println(src+pngText);
  		 }
  		 //��idΪaddress��td��ǩ�������һ��value����121212121��ֵ ��:<td id="address" value="121212121"></td>
  		 doc.getElementById("address").val("�㶫ʡ�Ƹ�����ݺ·��������");//����value��ֵ
  		 doc.getElementById("address").html("�㶫ʡ�Ƹ�����ݺ·��������");//����html��ֵ
  		 //��idΪname��td��ǩ���һ���ı�ֵ ��:<td id="name">121212121</td>
  		 doc.getElementById("name").html("��������");//
  		 
  		 String newHtml=doc.toString();
  		
  		System.out.println(newHtml);
	}
}
