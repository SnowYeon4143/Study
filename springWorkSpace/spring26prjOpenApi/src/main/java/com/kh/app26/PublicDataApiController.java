package com.kh.app26;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
public class PublicDataApiController {
	
	@GetMapping("/api-test")
	@ResponseBody
	public String apiTest() throws Exception {
		
		//api call
		String result = apiCall();
		
		//Gson�� �̿��ؼ� �ܼ��� ���ڿ��� Json ���� (JsonObject) �� �°� �ٲ㺸��
		
		//�ϴ� �Ľ� (String -> Json
		JsonObject resultObj = JsonParser.parseString(result).getAsJsonObject();
		System.out.println(resultObj);
		
		//Json ��ü���� Ű���� �̿��ؼ� ������ ������ (�޼ҵ� Ȱ�� || �Ľ�)
//		JsonObject responseObj = resultObj.get("response").getAsJsonObject();
		JsonObject responseObj = (JsonObject) resultObj.get("response");
		System.out.println(responseObj);
		
		//��� ���� responseObj�� Ű������ �̿��ؼ� ������ ����غ���
		JsonObject bodyObj = responseObj.get("body").getAsJsonObject();
		JsonObject headerObj = (JsonObject) responseObj.get("header");
		
		System.out.println(headerObj);
		System.out.println(bodyObj);
		
		//�ٵ� > 2�� Ű���� �ش��ϴ� value ����غ���
		String totalCount = bodyObj.get("totalCount").getAsString();
		System.out.println(totalCount);
		
		//�ٵ� �ȿ��� items Ű���� �ش��ϴ� value ����غ���
		
		
		return "api call ~~~";
	}
	
	private String apiCall() throws Exception {
		 
		 //URL ����
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
	     urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D"); /*Service Key*/
	     urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml �Ǵ� json*/
	     urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*�� ������ ��� ��*/
	     urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
	     urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*���� ����*/
	     urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*�̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ����*/
	     
	     //URL ��ü ����
	     URL url = new URL(urlBuilder.toString());
	     
	     //Ŀ�ؼ� ����
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         
         //�޼ҵ� ����, ��� ����
	     conn.setRequestMethod("GET");
	     conn.setRequestProperty("Content-type", "application/json");
	     
	     //���� �ڵ� Ȯ��
	     System.out.println("Response code: " + conn.getResponseCode());
	     
	     //Ŀ�ؼǿ��� ��Ʈ�� ������ (��ż��� : ��ǲ��Ʈ��), (��� ���� : ������Ʈ��)
	     BufferedReader rd;
	     if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	     } else {
	         rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	     }
	     
	     //������ �а�, sb�� ���� �� ������
	     StringBuilder sb = new StringBuilder();
	     String line;
	     while ((line = rd.readLine()) != null) {
	         sb.append(line);
	     }
	     
	     //����� �ڿ� �ݳ�
	     rd.close();
	     conn.disconnect();
	     
	     //��� Ȯ��
//       System.out.println(sb.toString());
		
		return sb.toString();
	}
}
