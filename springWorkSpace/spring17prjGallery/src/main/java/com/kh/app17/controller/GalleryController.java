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
	
	//��������
	//1. DB���� ������ ��������(path, size, name)
	//2. ���� �������� (��������)
	//3. ���� -> ����Ʈ
	//4. ���� ���� �غ� (header�� ����)
	//5. ����Ʈ ����
	
	//���� �ٿ�ε� (Response ���)
	@GetMapping("/Down/{no}")
	@ResponseBody
	public void down(@PathVariable int no, HttpServletResponse response) throws IOException {
		
		//no�� �´� ���� ������ ��������
		//DB���� no������ row��������
		GalleryVo vo = dao.getGallery(no);
		
		if(vo == null) {
			//����ڰ� ���� ������ ��û�ϸ� ����
			response.sendError(400);
		}
		
		//vo�� �������� ���� ����
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename= \"" + URLEncoder.encode(vo.getFname(), "UTF-8") + "\"");
		response.setHeader("Content-Length", String.valueOf(vo.getFsize()));
		
		//���� ����
		//���� ��ǻ���� ���� ������
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		//�� ������ ����Ʈ�� ��ȯ
		byte[] data = FileUtils.readFileToByteArray(file);
		//data�� ��������� ������
		response.getOutputStream().write(data);
	}
	
	//���� �ٿ�ε� (������)
	//ResponseEntity�� �̿��ϱ� (== ���� ��ƼƼ)
	@GetMapping("/down/{no}")
	public ResponseEntity down(@PathVariable int no) throws IOException {
		//no�� �´� ���� ������ ��������
		// DB���� no������ row��������
		GalleryVo vo = dao.getGallery(no);
		
		if(vo == null) {
			//���� ���� ��
			return ResponseEntity.notFound().build(); //��������
		}
		
		//���� ���� ��
		
		//���� �������� (������ǻ��) (����)
		File file = new File("C:\\dev\\06_Framework\\upload", String.valueOf(no));
		//������ byte�� ��ȯ (���� �ٸ�)
		byte[] data = FileUtils.readFileToByteArray(file);
		ByteArrayResource res = new ByteArrayResource(data);
		//����Ʈ ��� ������
		
		//���� ResponseEntity
		//ResponseEntity�� ����
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
