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
	 * JSoup思路：
	 *   1.根据标签定位置：--
	 *   2.jsoup创建<tr><td>节点-->
	 *   3.设置标签节点的值
	 *   4.标签的节点的追加 -->
	 *   5.在第3步页面已经有值.-->
	 *   6.直接生成一个到本地.
	 * @throws Exception
	 */
	public static void setHtml()throws Exception{
		String addrStr="广东省云浮市云城区东升布艺!";
		String nameStr="东升布艺";
		
		String path=JSoupHTML.class.getResource("JSoupHTML.class").getPath();
		path=path.substring(0,path.lastIndexOf("/")+1);
		File file=new File(path+url);
		
		Document doc=Jsoup.parse(file, "UTF-8");
		StringBuffer buff=new StringBuffer("");
		
		org.jsoup.nodes.Element table=doc.getElementById("mytab");//获取table的ID
		Element tr=doc.createElement("tr");//创建一个tr标签
		Element username=doc.createElement("td");
		username.html(nameStr);//html跟jQuery的html()函数
		Element address=doc.createElement("td");
		address.html(addrStr);//把内容设到<td>XXX</td>
		tr.appendChild(username);
		tr.appendChild(address);
		table.appendChild(tr);
		//把值设到input标签的value里面,val()跟jQuery的函数一样
		
		doc.getElementById("name").val(nameStr);//根据Id设值
		doc.getElementById("name").html(nameStr);//根据Id设值
		buff.append(doc.toString());
		
		doc.getElementById("address").val(addrStr);//根据Id设值
		doc.getElementById("address").html(addrStr);//根据Id设值
		buff.append(doc.toString());
		
		IoUtils.write(buff.toString(), "D:/"+System.currentTimeMillis()+".html");
	}
	public static void main(String[] args)throws Exception {
		setHtml();
	}
}
