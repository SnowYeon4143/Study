package main;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntDmstPrmsnPrdtService/getCovidDagnsRgntDmstPrmsnPrdtInq"); /* URL */
		String key = "tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D";
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + key); /* Service Key */
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* ������ ��ȣ */
		urlBuilder.append(
				"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /* �� ������ ��� �� */
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
				+ URLEncoder.encode("xml", "UTF-8")); /* ���䵥���� ����(xml/json) default : xml */
		urlBuilder.append(
				"&" + URLEncoder.encode("MEDDEV_ITEM_NO", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* ǰ���㰡��ȣ */
		urlBuilder.append("&" + URLEncoder.encode("BSSH_NM", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* ��ü�� */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}
