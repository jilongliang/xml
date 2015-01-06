package ivyy.taobao.com.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *@Author:liangjilong
 *@Date:2015-1-4
 *@Email:jilongliang@sina.com
 *@Version:1.0
 *@Description
 */

public class HttpRequestUtils {
	/**
	 * ����http����
	 * POST��GET���󶼿���
	 * @param requestUrl �����ַ
	 * @param method�����ִ�еķ�ʽ ��GET����POST��ʽ
	 * @return String
	 */
	public static String HttpURLConnRequest(String requestUrl,String method) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod(method);
			httpUrlConn.setUseCaches(false);  
			httpUrlConn.setInstanceFollowRedirects(true); //�ض���
			httpUrlConn.connect();
			// �����ص�������ת�����ַ���
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// �ͷ���Դ
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
