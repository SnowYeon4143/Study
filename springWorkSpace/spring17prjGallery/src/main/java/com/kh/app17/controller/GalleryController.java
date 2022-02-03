package com.kh.app17.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app17.repository.GalleryDao;
import com.kh.app17.service.GalleryService;
import com.kh.app17.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@Autowired
	private GalleryDao dao;
	
	@GetMapping("/enroll")
	public String enroll() {
		return "gallery/enroll";
	}
	
	@PostMapping("/enroll")
	public String enroll(GalleryVo vo, MultipartFile f) throws IllegalStateException, IOException {
		
		if(f.isEmpty()) {
			return "redirect:/errorPage";
		}
		
		int result = service.enroll(vo, f);
		
		if(result > 0) {
			return "redirect:/gallery/enroll";
		}else {
			return "redirect:/errorPage";
		}
		
	}
	
	//파일전송
	//1. DB에서 데이터 가져오기(path, size, name)
	//2. 파일 가져오기 (서버에서)
	//3. 파일 -> 바이트
	//4. 파일 전송 준비 (header를 수정)
	//5. 바이트 전송
	
	//파일 다운로드 (Response 방식)
	@GetMapping("/Down/{no}")
	@ResponseBody
	public void down(@PathVariable int no, HttpServletResponse response) throws IOException {
		
		//no에 맞는 파일 정보를 가져오기
		//DB가서 no값으로 row가져오기
		GalleryVo vo = dao.getGallery(no);
		
		if(vo == null) {
			//사용자가 없는 사진을 요청하면 에러
			response.sendError(400);
		}
		
		//vo를 바탕으로 파일 전송
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename= \"" + URLEncoder.encode(vo.getFname(), "UTF-8") + "\"");
		response.setHeader("Content-Length", String.valueOf(vo.getFsize()));
		
		//파일 전송
		//서버 컴퓨터의 파일 가져옴
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		//그 파일을 바이트로 변환
		byte[] data = FileUtils.readFileToByteArray(file);
		//data를 사용자한테 보내기
		response.getOutputStream().write(data);
	}
	
	//파일 다운로드 (스프링)
	//ResponseEntity를 이용하기 (== 응답 엔티티)
	@GetMapping("/down/{no}")
	public ResponseEntity down(@PathVariable int no) throws IOException {
		//no에 맞는 파일 정보를 가져오기
		// DB가서 no값으로 row가져오기
		GalleryVo vo = dao.getGallery(no);
		
		if(vo == null) {
			//파일 없을 때
			return ResponseEntity.notFound().build(); //빌드패턴
		}
		
		//파일 있을 때
		
		//파일 가져오기 (서버컴퓨터) (같음)
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		//파일을 byte로 변환 (조금 다름)
		byte[] data = FileUtils.readFileToByteArray(file);
		ByteArrayResource res = new ByteArrayResource(data);
		//바이트 덩어리 보내기
		
		//리턴 ResponseEntity
		//ResponseEntity에 세팅
		return ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(vo.getFsize())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= \"" + URLEncoder.encode(vo.getFname(), "UTF-8") + "\"")
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
				.body(res);
	}
	
//	@GetMapping("/test")
//	@ResponseBody
//	public String test(HttpServletResponse response) throws IOException {
//		return "helloWorld";
//	}
}
