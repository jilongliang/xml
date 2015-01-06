package ivyy.taobao.com.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *@Author:jilongliang
 *@Email:jilongliang@sina.com
 *@Date:2015-1-5
 *@CopyRight:liangjilong
 *@Description:JsoupLinks
 */
public class JsoupLinks {
	public static void main(String[] args) throws IOException {
		
		//Validate.isTrue(args.length == 1, "usage: supply url to fetch");
		
		String url ="http://image.baidu.com/";
		format("Fetching %s...", url);//ץȡ��ַ
		Document doc = Jsoup.connect(url).get();//
		Elements links = doc.select("a[href]");//href
		Elements media = doc.select("[src]");//src
		Elements imports = doc.select("link[href]");
		format("\nMedia: (%d)", media.size());
		for (Element src : media) {
			if (src.tagName().equals("img"))
				format(" * %s: <%s> %sx%s (%s)", 
						src.tagName(), 
						src.attr("abs:src"),
						src.attr("width"),
						src.attr("height"), 
						trim(src.attr("alt"), 20));
			else
				//��������Ҫȡ��һ������·������Ҫ��������ǰ�� abs: ǰ׺
				format(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
		}
		
		format("\nImports: (%d)", imports.size());
		for (Element link : imports) {
			format(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"),
					link.attr("rel"));
		}
		format("\nLinks:(%d)", links.size());
		for (Element link : links) {
			format(" * a: <%s> (%s)", link.attr("abs:href"), trim(link.text(),
					35));
		}
	}

	/***
	 * ��ʽ��
	 * @param msg
	 * @param args
	 */
	private static void format(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	/**
	 * ȥ���ո�
	 * @param s
	 * @param width
	 * @return
	 */
	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}