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
		
		//ȸ������ ó��
		
		//ȸ����ȣ ������ nextval
		int no = dao.getMemberSeq();
		
		//insert ó��
		dto.setUserNo(no);
		dto.setUserPwd(pe.encode(dto.getUserPwd()));
		log.info(dto.toString());//cbj
		int result = dao.insertMember(dto);
		
		/////////////////////////////
		
		//���� ���ε� (�츮 ������)
		MultipartFile f = dto.getF();
		
		if(!f.isEmpty()) {
			//���� �̸� (���) getOriginalFilename()
			//����� �̸� (���)
			//������ getSize()
			//Ÿ�� getContentType()
			
			//����� �̸�
			String changeName = System.currentTimeMillis() + "_" + f.getOriginalFilename();
			dto.setChangeName(changeName);
			
			String path = req.getServletContext().getRealPath("/resources/upload/profile/");

			File file = new File(path + changeName);
			f.transferTo(file);
			
			//db�� insert
			dao.uploadProfile(dto);
			
		}else {
			//����
		}
		
		return result;
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		
		//DB���� ȸ�� ���� ��ȸ
		MemberDto dbUser = dao.getMember(dto);
		if(dbUser == null) {
			return null;
		}
		
		//��� üũ
		//����� ���, DB ���
		if(pe.matches(dto.getUserPwd(), dbUser.getUserPwd())) {
			//����� ������ ��� ����
			return dbUser;
		}else {
			//Ʋ���� null ����
			return null;
		}
		
	}

	@Override
	public MemberDto editMember(MemberDto dto) throws Exception {
		//��й�ȣ �ѹ� �� Ȯ�� //�츮�� �н�
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
