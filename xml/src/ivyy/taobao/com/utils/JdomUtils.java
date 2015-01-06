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
 *@Description��
 */
public class JdomUtils {
	private static String encoding="utf-8";
	private static XMLOutputter out = null;
	
	/***
	 * ------------��ӡ------------
	 * @param doc
	 */
	public static void print(Document doc) {
		if(out==null){
			out=new XMLOutputter();
			//����XML�ļ������ʽ
			out.setFormat(Format.getCompactFormat().setEncoding(encoding));
		}
       System.out.println(out.outputString(doc));
   }
	
	
	/****
	 * ��ʽXML�ļ�
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
