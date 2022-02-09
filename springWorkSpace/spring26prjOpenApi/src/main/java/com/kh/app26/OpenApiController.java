package com.kh.app26;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/data")
public class OpenApiController {
	
	@GetMapping("/mise")
	public String mise() throws Exception {
		
		String result = callMise();
		
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		JsonObject responseObj = resultObj.getAsJsonObject("response");
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
		JsonArray items = bodyObj.getAsJsonArray("items");
		
		
		System.out.println(items);
		
		for(int i = 0; i < items.size(); ++i) {
			System.out.println(items.get(i));
		}
		
		return "data/mise";
	}
	
	private String callMise() throws Exception {
		String key = "tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D";
		
//		1. URL 셋팅 (요청 주소 + 파라미터들 셋팅)
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url.append("?");
		url.append("serviceKey=" + key); //필수
		url.append("&");
		url.append("returnType=json");
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
//		System.out.println(result);
		
		return result.toString();
	}
}
