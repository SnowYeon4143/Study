package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		//URL 셋팅 (주소, 파라미터)
		StringBuilder urlBuilder = new StringBuilder("http://127.0.0.1:8888/app26/"); /*URL*/
		
		//URL 객체 생성
		URL url = new URL(urlBuilder.toString());
		 
		 //커넥션 만듦
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		//메소드 설정, 헤더 설정
		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
		 
		//응답 코드 확인
		System.out.println("Response code: " + conn.getResponseCode());
		 
		//커넥션에서 스트림 가져옴 (무조건 가져옴)
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		 
		//데이터 읽고, sb에 전부 다 더해줌
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
		    sb.append(line);
		    System.out.println(line);
		}
		 
		//사용한 자원 반납
		rd.close();
		conn.disconnect();
		
		//결과 확인
//		System.out.println(sb.toString());
	}
}
