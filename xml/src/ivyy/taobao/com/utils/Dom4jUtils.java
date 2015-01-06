package ivyy.taobao.com.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *@Author:jilongliang
 *@Date:2013-7-24
 *@Description:
 */
@SuppressWarnings("all")
public class Dom4jUtils {
	
	/**
	 * xml��ʽ��
	 * @param document
	 * @param filePath
	 * @return
	 */
	public static boolean formatAsXML(Document document, String filePath) {
		boolean ret=true;
		OutputFormat format = OutputFormat.createPrettyPrint();// ��ʽ
		format.setEncoding("utf-8");// ���ø�ʽ����
		try {
			/** ��document�е�����д���ļ���new XMLWriter(new FileWriter(new File(filename))); */
			XMLWriter writer = new XMLWriter(new FileWriter(new File(filePath)),format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			ret=false;
		}
		return ret;
	}
	/**
	 * xml��ʽ��
	 * @param document
	 * @param filePath
	 * @return
	 */
	public static boolean formatAsXml(Document document) {
		boolean ret=true;
		OutputFormat format = OutputFormat.createPrettyPrint();// ��ʽ
		format.setEncoding("GBK");// ���ø�ʽ����
		try {
			/** ��document�е�����д���ļ���new XMLWriter(new FileWriter(new File(filename))); */
			XMLWriter writer = new XMLWriter(format);
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			ret=false;
		}
		return ret;
	}
	
}
