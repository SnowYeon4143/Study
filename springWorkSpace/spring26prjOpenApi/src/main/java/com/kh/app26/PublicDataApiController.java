package com.kh.app26;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;

//<JSON 데이터를 서버(java)에서 다루기>
//0. Gson ㅏㄹ이브러리 추가
//1. Json을 파싱 (Gson 라이브러리 활용해서 파싱)
//2. JsonObject에서 key값으로 value꺼내기
//3-1. 꺼낸 값이 String이라면 String 타입으로 바꿈 //getAsString();
//3-2. 꺼낸 값이 JsonObject라면 JsonObject 타입으로 바꿈 //getAsJsonObject();
//3-3. 꺼낸 값이 JsonArray라면 JsonArray 타입으로 바꿈 //getAsJsonArray();
//4. 3-1 => 그냥 변수에 담으면 되고,
//   3-2 => 다시 한번 2번 과정 진행
//   3-3 => java.util.List로 관리하면 편함
//   JsonObject 자체는 vo로 관리하면 편함
   
@Controller
public class PublicDataApiController {
	
	@GetMapping("/api-test")
	@ResponseBody
	public String apiTest() throws Exception {
		
		//api call
		String result = apiCall("3");
		
		//Gson을 이용해서 단순한 문자열을 Json 형식 (JsonObject) 에 맞게 바꿔보자
		
		//일단 파싱 (String -> Json
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		System.out.println(resultObj);
		
		//Json 객체에서 키값을 이용해서 데이터 꺼내기 (메소드 활용 || 파싱)
//		JsonObject responseObj = resultObj.get("response").getAsJsonObject();
		JsonObject responseObj = (JsonObject) resultObj.get("response");
		System.out.println(responseObj);
		
		//방금 꺼낸 responseObj의 키값들을 이용해서 데이터 출력해보기
		JsonObject bodyObj = responseObj.get("body").getAsJsonObject();
		JsonObject headerObj = (JsonObject) responseObj.get("header");
		
		System.out.println(headerObj);
		System.out.println(bodyObj);
		
		//바디 > 2개 키값에 해당하는 value 출력해보기
		String totalCount = bodyObj.get("totalCount").getAsString();
		System.out.println(totalCount);
		
		//body라는 json object 안에서 items 키값에 해당하는 value 출력해보기
//		JsonArray items = bodyObj.get("items").getAsJsonArray(); //메소드로 처리
		JsonArray items = (JsonArray) bodyObj.get("items");		 //casting으로 처리
		
		System.out.println("================================");
		System.out.println("items ::: " + items);
		System.out.println("================================");
		
		List<ItemVo> itemVoList = new ArrayList<ItemVo>();
		for(int i = 0; i < items.size(); i++) {
			JsonObject item = items.get(i).getAsJsonObject();
			System.out.println(item);
			
			String clearVal = item.get("clearVal").getAsString();
			String sn = item.get("sn").getAsString();
			String districtName = item.get("districtName").getAsString();
			String dataDate = item.get("dataDate").getAsString();
			String issueVal = item.get("issueVal").getAsString();
			
			ItemVo vo = new ItemVo();
			vo.setClearVal(clearVal);
			vo.setSn(sn);
			vo.setDistrictName(districtName);
			vo.setDataDate(dataDate);
			vo.setIssueVal(issueVal);
			
			itemVoList.add(vo);
		}

		for(ItemVo x : itemVoList) {
			System.out.println(x);
		}
		
		return "api call ~~~";
	}
	
	@GetMapping("/api-view")
	public String view() {
		
		return "data/apiView";
	}
	
	@GetMapping( value = "/api-resp", produces = /*"application/json;*/"text/xml; charset=UTF-8")
	@ResponseBody
	public String resp(String numOfRows) throws Exception {
		
		//api 호출
		String result = apiCall(numOfRows);
		//<response>~~~~~</response>
		//호출결과 리턴
		return result;
	}
	
	private String apiCall(String numOfRows) throws Exception {
		 
		 //URL 셋팅
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
	     urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D"); /*Service Key*/
	     urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml 또는 json*/
	     urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*한 페이지 결과 수*/
	     urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	     urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*측정 연도*/
	     urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*미세먼지 항목 구분(PM10, PM25), PM10/PM25 모두 조회할 경우 파라미터 생략*/
	     
	     //URL 객체 생성
	     URL url = new URL(urlBuilder.toString());
	     
	     //커넥션 만듦
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         
         //메소드 설정, 헤더 설정
	     conn.setRequestMethod("GET");
//	     conn.setRequestProperty("Content-type", "application/json");
	     
	     //응답 코드 확인
//	     System.out.println("Response code: " + conn.getResponseCode());
	     
	     //커넥션에서 스트림 가져옴 (통신성공 : 인풋스트림), (통신 실패 : 에러스트림)
	     BufferedReader rd;
	     if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	     } else {
	         rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	     }
	     
	     //데이터 읽고, sb에 전부 다 더해줌
	     StringBuilder sb = new StringBuilder();
	     String line;
	     while ((line = rd.readLine()) != null) {
	         sb.append(line);
	     }
	     
	     //사용한 자원 반납
	     rd.close();
	     conn.disconnect();
	     
	     //결과 확인
//       System.out.println(sb.toString());
		
		return sb.toString();
	}
}
