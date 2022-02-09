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
<자바에서 웹으로 요청하는 방법>
1. URL 셋팅 (요청 주소 + 파라미터들 셋팅)
2. URL 객체 생성 (1 에서 만든 URL 이용해서)
3. URL 을 이용해서 커넥션 가져오기 (가져온 커넥션을 http로 바꿔줘야 함)
4. request 의 요청방식(method) , header 설정
5. 커넥션 에서 inputStream 가져옴 (BufferedReader로 변환)
6. 5에서 가져온 스트림으로 데이터 한줄씩 읽기(누적시키기)
7. 사용한 자원들 (스트림 , 커넥션) 정리하기 (close, disconnect)
8. 출력해서 확인 ~~~
*/
//StringBuilder 설명하기
//connection을 이용해서 응답코드(responseCode) 확인 가능
//응답코드에 따른 처리 ( conn.getErrorStream() )

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String key = "tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D";
		
//		1. URL 셋팅 (요청 주소 + 파라미터들 셋팅)
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url.append("?");
		url.append("serviceKey=" + key); //필수
		url.append("&");
		url.append("returnType=xml");
		url.append("&");
		url.append("numOfRows=100");
		url.append("&");
		url.append("pageNo=1");
		url.append("&");
		url.append("year=2020"); //필수
		url.append("&");
		url.append("itemCode=PM10"); //한글은 URLEncoding 작업을 해줘야 URL에서 정상적으로 전달이 됨
		
//		2. URL 객체 생성 (1 에서 만든 URL 이용해서)
		URL urlObj = new URL(url.toString());
		
//		3. URL 을 이용해서 커넥션 가져오기 (가져온 커넥션을 http로 바꿔줘야 함)
		HttpURLConnection conn =  (HttpURLConnection) urlObj.openConnection();
		
//		4. request 의 요청방식(method) , header 설정
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
//		5. 커넥션 에서 inputStream 가져옴 (BufferedReader로 변환)
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
//		6. 5에서 가져온 스트림으로 데이터 한줄씩 읽기(누적시키기)
		StringBuilder result = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null) {
			result.append(line);
		}
		
//		7. 사용한 자원들 (스트림 , 커넥션) 정리하기 (close, disconnect)
		br.close();
		conn.disconnect();
		
//		8. 출력해서 확인 ~~~
		System.out.println(result);
		
		//원본코드
//		StringBuilder urlBuilder = new StringBuilder(
//				"http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /* URL */
//		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + key); /* Service Key */
//		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
//				+ URLEncoder.encode("xml", "UTF-8")); /* xml 또는 json */
//		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
//				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
//		urlBuilder
//				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
//		urlBuilder.append(
//				"&" + URLEncoder.encode("year", "UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /* 측정 연도 */
//		urlBuilder.append("&" + URLEncoder.encode("itemCode", "UTF-8") + "="
//				+ URLEncoder.encode("PM10", "UTF-8")); /* 미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략 */
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
