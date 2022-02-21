package com.kh.app999.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app999.member.dao.MemberDao;
import com.kh.app999.member.entity.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public int join(MemberDto dto, HttpServletRequest req) throws Exception {
		
		//회원가입 처리
		
		//회원번호 시퀀스 nextval
		int no = dao.getMemberSeq();
		
		//insert 처리
		dto.setUserNo(no);
		dto.setUserPwd(pe.encode(dto.getUserPwd()));
		log.info(dto.toString());//cbj
		int result = dao.insertMember(dto);
		
		/////////////////////////////
		
		//파일 업로드 (우리 서버에)
		MultipartFile f = dto.getF();
		
		if(!f.isEmpty()) {
			//원래 이름 (사용) getOriginalFilename()
			//변경된 이름 (사용)
			//사이즈 getSize()
			//타입 getContentType()
			
			//변경된 이름
			String changeName = System.currentTimeMillis() + "_" + f.getOriginalFilename();
			dto.setChangeName(changeName);
			
			String path = req.getServletContext().getRealPath("/resources/upload/profile/");

			File file = new File(path + changeName);
			f.transferTo(file);
			
			//db에 insert
			dao.uploadProfile(dto);
			
		}else {
			//ㄴㄴ
		}
		
		return result;
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		
		//DB에서 회원 정보 조회
		MemberDto dbUser = dao.getMember(dto);
		if(dbUser == null) {
			return null;
		}
		
		//비번 체크
		//사용자 비번, DB 비번
		if(pe.matches(dto.getUserPwd(), dbUser.getUserPwd())) {
			//비번이 맞으면 멤버 리턴
			return dbUser;
		}else {
			//틀리면 null 리턴
			return null;
		}
		
	}

	@Override
	public MemberDto editMember(MemberDto dto) throws Exception {
		//비밀번호 한번 더 확인 //우리는 패스
		if(dto.getUserPwd().length() > 0) {
			dto.setUserPwd(pe.encode(dto.getUserPwd()));			
		}
		
		int result = dao.updateMember(dto);
		
		MemberDto m = null;
		if(result > 0) {
			m = dao.getMember(dto);
		}
		
		return m;
	}

}
