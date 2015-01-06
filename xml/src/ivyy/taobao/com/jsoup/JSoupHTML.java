package ivyy.taobao.com.jsoup;

import ivyy.taobao.com.utils.IoUtils;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *@Author:jilongliang
 *@Email:jilongliang@sina.com
 *@Date:2015-1-5
 *@CopyRight:liangjilong
 *@Description:JSoupHTML
 */
public class JSoupHTML {
	private static String url="HtmlTemplate.html";
	/**
	 * JSoup˼·��
	 *   1.���ݱ�ǩ��λ�ã�--
	 *   2.jsoup����<tr><td>�ڵ�-->
	 *   3.���ñ�ǩ�ڵ��ֵ
	 *   4.��ǩ�Ľڵ��׷�� -->
	 *   5.�ڵ�3��ҳ���Ѿ���ֵ.-->
	 *   6.ֱ������һ��������.
	 * @throws Exception
	 */
	public static void setHtml()throws Exception{
		String addrStr="�㶫ʡ�Ƹ����Ƴ�����������!";
		String nameStr="��������";
		
		String path=JSoupHTML.class.getResource("JSoupHTML.class").getPath();
		path=path.substring(0,path.lastIndexOf("/")+1);
		File file=new File(path+url);
		
		Document doc=Jsoup.parse(file, "UTF-8");
		StringBuffer buff=new StringBuffer("");
		
		org.jsoup.nodes.Element table=doc.getElementById("mytab");//��ȡtable��ID
		Element tr=doc.createElement("tr");//����һ��tr��ǩ
		Element username=doc.createElement("td");
		username.html(nameStr);//html��jQuery��html()����
		Element address=doc.createElement("td");
		address.html(addrStr);//�������赽<td>XXX</td>
		tr.appendChild(username);
		tr.appendChild(address);
		table.appendChild(tr);
		//��ֵ�赽input��ǩ��value����,val()��jQuery�ĺ���һ��
		
		doc.getElementById("name").val(nameStr);//����Id��ֵ
		doc.getElementById("name").html(nameStr);//����Id��ֵ
		buff.append(doc.toString());
		
		doc.getElementById("address").val(addrStr);//����Id��ֵ
		doc.getElementById("address").html(addrStr);//����Id��ֵ
		buff.append(doc.toString());
		
		IoUtils.write(buff.toString(), "D:/"+System.currentTimeMillis()+".html");
	}
	public static void main(String[] args)throws Exception {
		setHtml();
	}
}
