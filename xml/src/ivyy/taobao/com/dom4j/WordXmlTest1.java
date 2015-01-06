package ivyy.taobao.com.dom4j;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *@Date:2015-1-5
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description：
 */
public class WordXmlTest1 {
 
	public static void main(String[] args) throws Exception {
		String fromRead=WordXmlTest1.class.getClassLoader().getResource("xml/office_word.xml").getPath();
		FileReader fr = null;
		int c = 0;
		try {
			fr = new FileReader(fromRead);
			int bf = 0;
			try {
				while ((c = fr.read()) != -1) {
					String str= String.valueOf(c);
					if(str=="<w:instrText>"){
						System.out.print((char) c);
					}
					bf++;
				}
				System.out.println("多少个字节:" + bf);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		fr.close();
	}
}

