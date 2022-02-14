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

//<JSON �����͸� ����(java)���� �ٷ��>
//0. Gson �����̺귯�� �߰�
//1. Json�� �Ľ� (Gson ���̺귯�� Ȱ���ؼ� �Ľ�)
//2. JsonObject���� key������ value������
//3-1. ���� ���� String�̶�� String Ÿ������ �ٲ� //getAsString();
//3-2. ���� ���� JsonObject��� JsonObject Ÿ������ �ٲ� //getAsJsonObject();
//3-3. ���� ���� JsonArray��� JsonArray Ÿ������ �ٲ� //getAsJsonArray();
//4. 3-1 => �׳� ������ ������ �ǰ�,
//   3-2 => �ٽ� �ѹ� 2�� ���� ����
//   3-3 => java.util.List�� �����ϸ� ����
//   JsonObject ��ü�� vo�� �����ϸ� ����
   
@Controller
public class PublicDataApiController {
	
	@GetMapping("/api-test")
	@ResponseBody
	public String apiTest() throws Exception {
		
		//api call
		String result = apiCall("3");
		
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
		
		//body��� json object �ȿ��� items Ű���� �ش��ϴ� value ����غ���
//		JsonArray items = bodyObj.get("items").getAsJsonArray(); //�޼ҵ�� ó��
		JsonArray items = (JsonArray) bodyObj.get("items");		 //casting���� ó��
		
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
		
		//api ȣ��
		String result = apiCall(numOfRows);
		//<response>~~~~~</response>
		//ȣ���� ����
		return result;
	}
	
	private String apiCall(String numOfRows) throws Exception {
		 
		 //URL ����
		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/UlfptcaAlarmInqireSvc/getUlfptcaAlarmInfo"); /*URL*/
	     urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=tFe6mYx%2FiL%2BcVdWYOel8z84D8gcmjZ%2Bgj7z1rokATJn5kTyBTfIjbD07XrAKNtGJckW51aX%2BYIurzZljjN8ifw%3D%3D"); /*Service Key*/
	     urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml �Ǵ� json*/
	     urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8")); /*�� ������ ��� ��*/
	     urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*��������ȣ*/
	     urlBuilder.append("&" + URLEncoder.encode("year","UTF-8") + "=" + URLEncoder.encode("2020", "UTF-8")); /*���� ����*/
	     urlBuilder.append("&" + URLEncoder.encode("itemCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*�̼����� �׸� ����(PM10, PM25), PM10/PM25 ��� ��ȸ�� ��� �Ķ���� ����*/
	     
	     //URL ��ü ����
	     URL url = new URL(urlBuilder.toString());
	     
	     //Ŀ�ؼ� ����
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         
         //�޼ҵ� ����, ��� ����
	     conn.setRequestMethod("GET");
//	     conn.setRequestProperty("Content-type", "application/json");
	     
	     //���� �ڵ� Ȯ��
//	     System.out.println("Response code: " + conn.getResponseCode());
	     
	     //Ŀ�ؼǿ��� ��Ʈ�� ������ (��ż��� : ��ǲ��Ʈ��), (��� ���� : ������Ʈ��)
	     BufferedReader rd;
	     if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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
