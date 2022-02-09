package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
<�ڹٿ��� ������ ��û�ϴ� ���>
1. URL ���� (��û �ּ� + �Ķ���͵� ����)
2. URL ��ü ���� (1 ���� ���� URL �̿��ؼ�)
3. URL �� �̿��ؼ� Ŀ�ؼ� �������� (������ Ŀ�ؼ��� http�� �ٲ���� ��)
4. request �� ��û���(method) , header ����
5. Ŀ�ؼ� ���� inputStream ������ (BufferedReader�� ��ȯ)
6. 5���� ������ ��Ʈ������ ������ ���پ� �б�(������Ű��)
7. ����� �ڿ��� (��Ʈ�� , Ŀ�ؼ�) �����ϱ� (close, disconnect)
8. ����ؼ� Ȯ�� ~~~
*/
//StringBuilder �����ϱ�
//connection�� �̿��ؼ� �����ڵ�(responseCode) Ȯ�� ����
//�����ڵ忡 ���� ó�� ( conn.getErrorStream() )

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String key = "tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D";
		
//		1. URL ���� (��û �ּ� + �Ķ���͵� ����)
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url.append("?");
		url.append("serviceKey=" + key); //�ʼ�
		url.append("&");
		url.append("returnType=xml");
		url.append("&");
		url.append("numOfRows=100");
		url.append("&");
		url.append("pageNo=1");
		url.append("&");
		url.append("year=2020"); //�ʼ�
		url.append("&");
		url.append("itemCode=PM10"); //�ѱ��� URLEncoding �۾��� ����� URL���� ���������� ������ ��
		
//		2. URL ��ü ���� (1 ���� ���� URL �̿��ؼ�)
		URL urlObj = new URL(url.toString());
		
//		3. URL �� �̿��ؼ� Ŀ�ؼ� �������� (������ Ŀ�ؼ��� http�� �ٲ���� ��)
		HttpURLConnection conn =  (HttpURLConnection) urlObj.openConnection();
		
//		4. request �� ��û���(method) , header ����
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
//		5. Ŀ�ؼ� ���� inputStream ������ (BufferedReader�� ��ȯ)
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
//		6. 5���� ������ ��Ʈ������ ������ ���پ� �б�(������Ű��)
		StringBuilder result = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null) {
			result.append(line);
		}
		
//		7. ����� �ڿ��� (��Ʈ�� , Ŀ�ؼ�) �����ϱ� (close, disconnect)
		br.close();
		conn.disconnect();
		
//		8. ����ؼ� Ȯ�� ~~~
		System.out.println(result);
		
		//�����ڵ�
//		StringBuilder urlBuilder = new StringBuilder(
//				"http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /* URL */
//		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + key); /* Service Key */
//		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
//				+ URLEncoder.encode("xml", "UTF-8")); /* xml �Ǵ� json */
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
//				+ URLEncoder.encode("100", "UTF-8")); /* �� ������ ��� �� */
//		urlBuilder
//				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* ��������ȣ */
//		urlBuilder.append(
//				"&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /* ���� ���� */
//		urlBuilder.append("&" + URLEncoder.encode("itemCode", "UTF-8") + "="
//				+ URLEncoder.encode("PM10", "UTF-8")); /* �̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ���� */
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
//		BufferedReader rd;
//		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
//		System.out.println(sb.toString());
	}
}
