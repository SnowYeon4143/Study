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
		
//		1. URL ���� (��û �ּ� + �Ķ���͵� ����)
		StringBuilder url = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo");
		url.append("?");
		url.append("serviceKey=" + key); //�ʼ�
		url.append("&");
		url.append("returnType=json");
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
//		System.out.println(result);
		
		return result.toString();
	}
}
