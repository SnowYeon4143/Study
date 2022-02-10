package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		//URL ���� (�ּ�, �Ķ����)
		StringBuilder urlBuilder = new StringBuilder("http://127.0.0.1:8888/app26/"); /*URL*/
		
		//URL ��ü ����
		URL url = new URL(urlBuilder.toString());
		 
		 //Ŀ�ؼ� ����
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		//�޼ҵ� ����, ��� ����
		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
		 
		//���� �ڵ� Ȯ��
		System.out.println("Response code: " + conn.getResponseCode());
		 
		//Ŀ�ؼǿ��� ��Ʈ�� ������ (������ ������)
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		 
		//������ �а�, sb�� ���� �� ������
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		    sb.append(line);
		    System.out.println(line);
		}
		 
		//����� �ڿ� �ݳ�
		rd.close();
		conn.disconnect();
		
		//��� Ȯ��
//		System.out.println(sb.toString());
	}
}
