package ivyy.taobao.com.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *@Date:2015-1-6
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class JdomUtils {
	private static String encoding="utf-8";
	private static XMLOutputter out = null;
	
	/***
	 * ------------打印------------
	 * @param doc
	 */
	public static void print(Document doc) {
		if(out==null){
			out=new XMLOutputter();
			//设置XML文件编码格式
			out.setFormat(Format.getCompactFormat().setEncoding(encoding));
		}
       System.out.println(out.outputString(doc));
   }
	
	
	/****
	 * 格式XML文件
	 * @param doc
	 * @param filePath
	 * @return
	 */
	public static XMLOutputter formatAsXML(Document doc,String filePath){
	  	Format format=Format.getPrettyFormat();
        format.setEncoding(encoding);
        format.setIndent("      ");
        format.setLineSeparator("\r\n");   
        XMLOutputter outer = new XMLOutputter(format);
        try {
			outer.output(doc, new FileOutputStream(filePath));
			return outer;
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
}
