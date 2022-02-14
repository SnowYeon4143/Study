package com.kh.app999.member.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app999.member.dao.MemberDao;
import com.kh.app999.member.entity.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Override
	public int join(MemberDto dto) throws Exception {
		
		//ȸ������ ó��
		
		//ȸ����ȣ ������ nextval
		int no = dao.getMemberSeq();
		
		//insert ó��
		dto.setUserNo(no);
		log.info(dto.toString());//cbj
		int result = dao.insertMember(dto);
		
		return result;
	}

}
